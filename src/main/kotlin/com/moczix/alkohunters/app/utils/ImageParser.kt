package com.moczix.alkohunters.app.utils

import com.moczix.alkohunters.app.config.AppConfig
import org.imgscalr.Scalr
import java.awt.Color
import java.net.URL
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.io.File
import com.sun.deploy.uitoolkit.ToolkitStore.dispose
import java.awt.Graphics2D
import org.apache.coyote.http11.Constants.a






class ImageParser {

    fun saveFileFromUrl(uri: String, name: String) {
        ImageIO.write(
                combineLayer(
                        scaleImage(convertToJpg(getOriginalImage(uri))),
                        getWhiteSquare()
                ),
                "jpg",
                getFileOutput(name))
    }

    private fun getOriginalImage(uri: String): BufferedImage {
        return ImageIO.read(URL(uri))
    }

    private fun scaleImage(resizedImage: BufferedImage): BufferedImage {
        return Scalr.resize(resizedImage, 200)
    }

    private fun convertToJpg(originalImage: BufferedImage): BufferedImage {
        val image = BufferedImage(
                originalImage.width,
                originalImage.height,
                BufferedImage.TYPE_INT_RGB)
        image.createGraphics().drawImage(originalImage, 0, 0, Color.WHITE, null)
        return image
    }

    private fun getFileOutput(name: String):File {
        return File("${AppConfig.storagePath}/alcohol_${name}.jpg")
    }

    private fun getWhiteSquare(): BufferedImage {
        val whiteImage = BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB)
        val g2d = whiteImage.createGraphics()
        g2d.paint = Color.WHITE
        g2d.fillRect(0,0, whiteImage.width, whiteImage.height)
        g2d.dispose()
        return whiteImage
    }

    private fun combineLayer(originalImage: BufferedImage, whiteImage: BufferedImage): BufferedImage {
        val layer = BufferedImage(whiteImage.width, whiteImage.height, BufferedImage.TYPE_INT_RGB)
        val graphicsLayer = layer.graphics
        graphicsLayer.drawImage(whiteImage, 0, 0, null)
        graphicsLayer.drawImage(originalImage, 0, 0, null)
        graphicsLayer.dispose()
        return layer
    }

}