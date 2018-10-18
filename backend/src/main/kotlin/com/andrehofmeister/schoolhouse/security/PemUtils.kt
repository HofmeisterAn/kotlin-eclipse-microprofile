package com.andrehofmeister.schoolhouse.security

import org.bouncycastle.util.io.pem.PemReader
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.security.KeyFactory
import java.security.PrivateKey
import java.security.PublicKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec

internal class PemUtils {
  companion object {
    private fun parsePEMFile(pemFile: File): ByteArray {
      if (!pemFile.isFile && !pemFile.exists()) {
        throw FileNotFoundException("The file '${pemFile.absolutePath}' doesn't exist.")
      }

      FileReader(pemFile).use {
        return PemReader(it).readPemObject().content
      }
    }

    private fun getPublicKey(keyBytes: ByteArray, algorithm: String): PublicKey {
      val keyFactory = KeyFactory.getInstance(algorithm)
      val keySpec = X509EncodedKeySpec(keyBytes)
      return keyFactory.generatePublic(keySpec)
    }

    private fun getPrivateKey(keyBytes: ByteArray, algorithm: String): PrivateKey {
      val keyFactory = KeyFactory.getInstance(algorithm)
      val keySpec = PKCS8EncodedKeySpec(keyBytes)
      return keyFactory.generatePrivate(keySpec)
    }

    fun readPublicKeyFromFile(filePath: String, algorithm: String): PublicKey {
      val bytes = PemUtils.parsePEMFile(File(filePath))
      return PemUtils.getPublicKey(bytes, algorithm)
    }

    fun readPrivateKeyFromFile(filePath: String, algorithm: String): PrivateKey {
      val bytes = PemUtils.parsePEMFile(File(filePath))
      return PemUtils.getPrivateKey(bytes, algorithm)
    }
  }
}
