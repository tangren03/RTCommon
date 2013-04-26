package com.ryantang.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
/**
 * Some common functions for image operation
 * @author Ryan
 *
 */
public class ImageUtils {
	
	/**
	 * Drawable convert to bitmap
	 * @param drawable
	 * @return
	 */
	public static Bitmap drawableToBitmap(Drawable drawable) {  
		if (drawable != null) {
			int w = drawable.getIntrinsicWidth();  
	        int h = drawable.getIntrinsicHeight();  
	        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888  
	                : Bitmap.Config.RGB_565;  
	        Bitmap bitmap = Bitmap.createBitmap(w, h, config);  
	        Canvas canvas = new Canvas(bitmap);  
	        drawable.setBounds(0, 0, w, h);  
	        drawable.draw(canvas);  
	        return bitmap;
		}else {
			return null;
		}
    }  
	
	/**
	 * Bitmap convert to drawable
	 * @param bitmap
	 * @return
	 */
	public static Drawable bitmapToDrawable(Bitmap bitmap){
		if (bitmap != null) {
			return new BitmapDrawable(bitmap);
		}else {
			return null;
		}
	}
	
	/**
	 * Stream convert to bitmap
	 * @param inputStream
	 * @return
	 * @throws Exception
	 */
	public static Bitmap inputStreamToBitmap(InputStream inputStream)
			throws Exception {
		if (inputStream != null) {
			return BitmapFactory.decodeStream(inputStream);
		}else {
			return null;
		}
	}

	/**
	 * Bytes convert to bitmap
	 * @param byteArray
	 * @return
	 */
	public static Bitmap bytesToBitmap(byte[] byteArray) {
		if (byteArray != null && byteArray.length != 0) {
			return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
		} else {
			return null;
		}
	}

	/**
	 * Bytes convert to drawable
	 * @param byteArray
	 * @return
	 */
	public static Drawable byteToDrawable(byte[] byteArray) {
		if (byteArray != null && byteArray.length > 0) {
			ByteArrayInputStream ins = new ByteArrayInputStream(byteArray);
			return Drawable.createFromStream(ins, null);
		}else {
			return null;
		}
		
	}

	/**
	 * Bitmap convert to bytes
	 * 
	 * @param byteArray
	 * @return
	 */
	public static byte[] bitmapToBytes(Bitmap bm) {
		if (bm != null) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
			byte[] bytes = baos.toByteArray();
			return bytes;
		}else {
			return null;
		}
		
	}

	/**
	 * Drawable convert to bytes
	 * @param drawable
	 * @return
	 */
	public static byte[] drawableToBytes(Drawable drawable) {
		if (drawable != null) {
			BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
			Bitmap bitmap = bitmapDrawable.getBitmap();
			byte[] bytes = bitmapToBytes(bitmap);
			;
			return bytes;
		}else {
			return null;
		}
		
	}

	/**
	 * Base64 convert to byte[]
	 */
	public static byte[] base64ToBytes(String base64) throws IOException {
		if (base64 != null && !base64.equals("")) {
			byte[] bytes = Base64.decode(base64);
			return bytes;
		}else {
			return null;
		}
	}

	/**
	 * Bytes convert to Base64
	 */
	public static String bytesToBase64(byte[] bytes) {
		if (bytes != null && bytes.length > 0) {
			String base64 = Base64.encode(bytes);
			return base64;
		}else {
			return null;
		}
	}
	
	/**
	 * Get reflection image from bitmap
	 * @param bitmap
	 * @return
	 */
	public static Bitmap getReflectionImageWithBitmap(Bitmap bitmap) {
		if (bitmap != null) {
			final int reflectionGap = 4;  
		    int w = bitmap.getWidth();  
		    int h = bitmap.getHeight();  
		    Matrix matrix = new Matrix();  
		    matrix.preScale(1, -1);  
		    Bitmap reflectionImage = Bitmap.createBitmap(bitmap, 0, h / 2, w,  
		            h / 2, matrix, false);  
		  
		    Bitmap bitmapWithReflection = Bitmap.createBitmap(w, (h + h / 2),  
		            Config.ARGB_8888);  
		  
		    Canvas canvas = new Canvas(bitmapWithReflection);  
		    canvas.drawBitmap(bitmap, 0, 0, null);  
		    Paint deafalutPaint = new Paint();  
		    canvas.drawRect(0, h, w, h + reflectionGap, deafalutPaint);  
		  
		    canvas.drawBitmap(reflectionImage, 0, h + reflectionGap, null);  
		  
		    Paint paint = new Paint();  
		    LinearGradient shader = new LinearGradient(0, bitmap.getHeight(), 0,  
		            bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff,  
		            0x00ffffff, TileMode.CLAMP);  
		    paint.setShader(shader);  
		    // Set the Transfer mode to be porter duff and destination in  
		    paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));  
		    // Draw a rectangle using the paint with our linear gradient  
		    canvas.drawRect(0, h, w, bitmapWithReflection.getHeight()  
		            + reflectionGap, paint);  
		    return bitmapWithReflection; 
		}else {
			return null;
		}
	}  

	/**
	 * Get rounded corner image
	 * @param bitmap
	 * @param roundPx 5 10
	 * @return
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
		if (bitmap != null) {
			 int w = bitmap.getWidth();  
			    int h = bitmap.getHeight();  
			    Bitmap output = Bitmap.createBitmap(w, h, Config.ARGB_8888);  
			    Canvas canvas = new Canvas(output);  
			    final int color = 0xff424242;  
			    final Paint paint = new Paint();  
			    final Rect rect = new Rect(0, 0, w, h);  
			    final RectF rectF = new RectF(rect);  
			    paint.setAntiAlias(true);  
			    canvas.drawARGB(0, 0, 0, 0);  
			    paint.setColor(color);  
			    canvas.drawRoundRect(rectF, roundPx, roundPx, paint);  
			    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));  
			    canvas.drawBitmap(bitmap, rect, rect, paint);  
			    return output;  
		}else {
			return null;
		}
	}  
	
	/**
	 * Resize the image
	 * @param bitmap
	 * @param width
	 * @param height
	 * @return
	 */
	public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
		if (bitmap != null) {
			int w = bitmap.getWidth();  
		    int h = bitmap.getHeight();  
		    Matrix matrix = new Matrix();  
		    float scaleWidth = ((float) width / w);  
		    float scaleHeight = ((float) height / h);  
		    matrix.postScale(scaleWidth, scaleHeight);  
		    Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);  
		    return newbmp;  
		}else {
			return null;
		}
	}
	
	/**
	 * Resize the drawable
	 * @param drawable
	 * @param w
	 * @param h
	 * @return
	 */
	public static Drawable zoomDrawable(Drawable drawable, int w, int h) {
		if (drawable != null) {
			int width = drawable.getIntrinsicWidth();  
		    int height = drawable.getIntrinsicHeight();  
		    Bitmap oldbmp = drawableToBitmap(drawable);  
		    Matrix matrix = new Matrix();  
		    float sx = ((float) w / width);  
		    float sy = ((float) h / height);  
		    matrix.postScale(sx, sy);  
		    Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height,  
		            matrix, true);  
		    return new BitmapDrawable(newbmp); 
		}else {
			return null;
		}
	} 
	
	/**
	 * Check the SD card 
	 * @return
	 */
	public static boolean checkSDCardAvailable(){
		return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
	}

	/**
	 * Delete all picture files in sd card
	 * @param path
	 */
	public static void deleteAllPictures(String path){
		if (checkSDCardAvailable()) {
			File folder = new File(path);
			File[] files = folder.listFiles();
			for (int i = 0; i < files.length; i++) {
				files[i].delete();
			}
		}
	}
	
	/**
	 * Delete picture
	 * @param path
	 * @param fileName
	 */
	public static boolean deletePicture(String path,String fileName){
		if (checkSDCardAvailable()) {
			if (isPictureExistsInSDCard(path, fileName)) {
				File folder = new File(path);
				File[] files = folder.listFiles();
				for (int i = 0; i < files.length; i++) {
					System.out.println("deletePicture：" + files[i].getName());
					if (files[i].getName().equals(fileName)) {
						return files[i].delete();
					}
				}
			}
			
		}
		return false;
	}
	
	/**
	 * Save image to the SD card 
	 * @param photoBitmap
	 * @param photoName
	 * @param path
	 */
	public static boolean savePictureToSDCard(Bitmap photoBitmap,String path,String photoName){
		boolean flag = false;
		if (checkSDCardAvailable()) {
			File dir = new File(path);
			if (!dir.exists()){
				dir.mkdirs();
			}
			
			File photoFile = new File(path , photoName);
			
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(photoFile);
				
				if (photoBitmap != null ) {
					if (photoBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
						fileOutputStream.flush();
						fileOutputStream.close();
						flag = true;
					}
				}
			} catch (FileNotFoundException e) {
				photoFile.delete();
				e.printStackTrace();
			} catch (IOException e) {
				photoFile.delete();
				e.printStackTrace();
			}
		} 
		return flag;
	}
	
	/**
	 * Get images from SD card by path and the name of image
	 * @param photoName
	 * @return
	 */
	public static Bitmap getPictureFromSDCard(String path,String photoName){
		Bitmap photoBitmap = BitmapFactory.decodeFile(path + "/" +photoName);
		if (photoBitmap == null) {
			return null;
		}else {
			return photoBitmap;
		}
	}
	
	/**
	 * Check if the picture exists in the SD card
	 * @param path
	 * @param photoName
	 * @return
	 */
	public static boolean isPictureExistsInSDCard(String path,String photoName){
		boolean flag = false;
		if (checkSDCardAvailable()) {
			File dir = new File(path);
			if (dir.exists()) {
				File folders = new File(path);
				File photoFile[] = folders.listFiles();
				for (int i = 0; i < photoFile.length; i++) {
					String fileName = photoFile[i].getName();
					System.out.println("isPictureExistsInSDCard:"+fileName);
					if (fileName.equals(photoName)) {
						flag = true;
						break;
					}
				}
			}else {
				flag = false;
			}
		}else {
			flag = false;
		}
		return flag;
	}
}
