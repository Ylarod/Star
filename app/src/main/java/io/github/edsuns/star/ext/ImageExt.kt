package io.github.edsuns.star.ext

import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import me.devilsen.czxing.code.BarcodeReader

/**
 * Created by Edsuns@qq.com on 2021/07/07.
 */

fun ContentResolver.getBitmap(uri: Uri): Bitmap {
    return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
        BitmapFactory.decodeStream(openInputStream(uri))
    } else {
        val source = ImageDecoder.createSource(this, uri)
        ImageDecoder.decodeBitmap(source)
    }
}

fun decodeQRCode(contentResolver: ContentResolver, uri: Uri): String? {
    return BarcodeReader.getInstance().read(contentResolver.getBitmap(uri))?.text
}
