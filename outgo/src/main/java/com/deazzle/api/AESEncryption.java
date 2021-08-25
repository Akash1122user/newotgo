package com.deazzle.api;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64.Decoder;
import java.util.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Class for cryptographic functions required.
 */
public class AESEncryption {
	/**
	 * number of right shifts.
	 */
	private static final int NUMBER_OF_RIGHT_SHIFTS = 4;
	/**
	 * number 255 in hex format.
	 */
	private static final int HEX_255 = 0xFF;
	/**
	 * number 15 in hex format.
	 */
	private static final int HEX_15 = 15;
	/**
	 * TAG string to tag logging.
	 */
	private static final String TAG = "AESEncryption";
	/**
	 * Secrete key for encryption and decryption.
	 */
	private static final String BIZ_IDENTIFIER = "YUdGemRHRnNZWFpwYzNSaE1USTJKQT09";
	/**
	 * String of hexadecimal digits.
	 */
	private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
	/**
	 * Block size for cryptography.
	 */
	private static final int BLOCK_SIZE = 16;

	/**
	 * Converts from bytes to string.
	 * 
	 * @param bytes byte array to convert
	 * @return converted string
	 */
	private static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & HEX_255;
			hexChars[j * 2] = HEX_ARRAY[v >>> NUMBER_OF_RIGHT_SHIFTS];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & HEX_15];
		}
		return new String(hexChars);
	}

	/**
	 * Converts from hex string to bytes.
	 * 
	 * @param string byte array to convert
	 * @return converted string
	 */
	private static byte[] hexToByte(String string) {
		byte[] b = new byte[string.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(string.substring(index, index + 2), BLOCK_SIZE);
			b[i] = (byte) v;
		}
		return b;
	}

	/**
	 * Deriving both key and IV from a password and a salt.
	 * 
	 * @param password byte array of password
	 * @param salt     byte array of salt
	 * @return byte array of key and iv
	 * @throws NoSuchAlgorithmException This exception is thrown when a particular
	 *                                  cryptographic algorithm is requested but is
	 *                                  not available in the environment.
	 */
	private static byte[] deriveKeyAndIV(byte[] password, byte[] salt) throws NoSuchAlgorithmException {
		final int resByteArrayInitializer = 48;
		final int hashThreeDestPos = 32;
		byte[] res = new byte[resByteArrayInitializer];
		final MessageDigest md5 = MessageDigest.getInstance("MD5");

		md5.update(password);
		md5.update(salt);
		byte[] hashOne = md5.digest();

		md5.reset();
		md5.update(hashOne);
		md5.update(password);
		md5.update(salt);
		byte[] hashTwo = md5.digest();

		md5.reset();
		md5.update(hashTwo);
		md5.update(password);
		md5.update(salt);
		byte[] hashThree = md5.digest();

		// 3 hash
		System.arraycopy(hashOne, 0, res, 0, BLOCK_SIZE);
		System.arraycopy(hashTwo, 0, res, BLOCK_SIZE, BLOCK_SIZE);
		System.arraycopy(hashThree, 0, res, hashThreeDestPos, BLOCK_SIZE);
		return res;
	}

	/**
	 * Encryption only for password field.
	 * 
	 * @param secret String of secret key.
	 * @param data   plain text password to encrypt.
	 * @return Encrypted password string
	 * @throws NoSuchAlgorithmException           This exception is thrown when a
	 *                                            particular cryptographic algorithm
	 *                                            is requested but is not available
	 *                                            in the environment.
	 * @throws NoSuchPaddingException             This exception is thrown when a
	 *                                            particular padding mechanism is
	 *                                            requested but is not available in
	 *                                            the environment.
	 * @throws InvalidKeyException                This is the exception for invalid
	 *                                            Keys (invalid encoding, wrong
	 *                                            length, uninitialized, etc).
	 * @throws InvalidAlgorithmParameterException This is the exception for invalid
	 *                                            or inappropriate algorithm
	 *                                            parameters.
	 * @throws IllegalBlockSizeException          This exception is thrown when the
	 *                                            length of data provided to a block
	 *                                            cipher is incorrect, i.e., does
	 *                                            not match the block size of the
	 *                                            cipher.
	 * @throws BadPaddingException                This exception is thrown when a
	 *                                            particular padding mechanism is
	 *                                            expected for the input data but
	 *                                            the data is not padded properly.
	 * @throws UnsupportedEncodingException       The Character Encoding is not
	 *                                            supported.
	 */
	private static String encryptPassword(String secret, String data) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException,
			BadPaddingException, UnsupportedEncodingException {
		final int saltInitializer = 8;
		final int keyStartIndex = 0;
		final int keyEndIndex = 32;
		final int ivStartIndex = 32;
		final int ivEndIndex = 48;
		final int saltLength = 8;
		byte[] salt = new byte[saltInitializer];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(salt);

		byte[] keyAndIV = deriveKeyAndIV(secret.getBytes(), salt);
		byte[] key = Arrays.copyOfRange(keyAndIV, keyStartIndex, keyEndIndex);
		byte[] iv = Arrays.copyOfRange(keyAndIV, ivStartIndex, ivEndIndex);
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
		IvParameterSpec ivspec = new IvParameterSpec(iv);

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivspec);
		byte[] encrypted = cipher.doFinal(data.getBytes());

		byte[] strToEncode;
		strToEncode = new byte[BLOCK_SIZE + encrypted.length];

		System.arraycopy(bytesToHex(salt).getBytes("UTF-8"), 0, new byte[BLOCK_SIZE + encrypted.length], 0, saltLength);
		System.arraycopy(bytesToHex(encrypted).getBytes("UTF-8"), 0, new byte[BLOCK_SIZE + encrypted.length],
				BLOCK_SIZE, encrypted.length);
		// return Base64.encodeToString((bytesToHex(salt) +
		// bytesToHex(encrypted)).getBytes("UTF-8"), Base64.NO_WRAP);
		return Base64.getEncoder().encodeToString((bytesToHex(salt) + bytesToHex(encrypted)).getBytes("UTF-8"));
	}

	/**
	 * Encryption only for password field.
	 * 
	 * @param password Plain text password to encrypt
	 * @return Encrypted password string
	 * @throws NoSuchAlgorithmException           This exception is thrown when a
	 *                                            particular cryptographic algorithm
	 *                                            is requested but is not available
	 *                                            in the environment.
	 * @throws NoSuchPaddingException             This exception is thrown when a
	 *                                            particular padding mechanism is
	 *                                            requested but is not available in
	 *                                            the environment.
	 * @throws InvalidKeyException                This is the exception for invalid
	 *                                            Keys (invalid encoding, wrong
	 *                                            length, uninitialized, etc).
	 * @throws InvalidAlgorithmParameterException This is the exception for invalid
	 *                                            or inappropriate algorithm
	 *                                            parameters.
	 * @throws IllegalBlockSizeException          This exception is thrown when the
	 *                                            length of data provided to a block
	 *                                            cipher is incorrect, i.e., does
	 *                                            not match the block size of the
	 *                                            cipher.
	 * @throws BadPaddingException                This exception is thrown when a
	 *                                            particular padding mechanism is
	 *                                            expected for the input data but
	 *                                            the data is not padded properly.
	 * @throws UnsupportedEncodingException       The Character Encoding is not
	 *                                            supported.
	 */
	public static String encrypt(String password) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException,
			UnsupportedEncodingException {

		byte[] s = Base64.getDecoder().decode(BIZ_IDENTIFIER.getBytes());
		byte[] t = Base64.getDecoder().decode(s);
		String secret = new String(t);
//		System.out.println("encript secret-->" + secret);
		String encryptedPassword = encryptPassword(secret, password); // take the value from user password edit text
	//	System.out.println("Encrypted password is: " + encryptedPassword);
		// Log.v(TAG, "Encrypted password is: " + encryptedPassword);
		return encryptedPassword;
	}

	/**
	 * Decrypts encoded text in to plain text. This method does not provide
	 * decryption for above encryption methods.
	 * 
	 * @param encryptedText Encrypted text to decode.
	 * @return Plain text string
	 * @throws NoSuchAlgorithmException           This exception is thrown when a
	 *                                            particular cryptographic algorithm
	 *                                            is requested but is not available
	 *                                            in the environment.
	 * @throws NoSuchPaddingException             This exception is thrown when a
	 *                                            particular padding mechanism is
	 *                                            requested but is not available in
	 *                                            the environment.
	 * @throws InvalidKeyException                This is the exception for invalid
	 *                                            Keys (invalid encoding, wrong
	 *                                            length, uninitialized, etc).
	 * @throws InvalidAlgorithmParameterException This is the exception for invalid
	 *                                            or inappropriate algorithm
	 *                                            parameters.
	 * @throws IllegalBlockSizeException          This exception is thrown when the
	 *                                            length of data provided to a block
	 *                                            cipher is incorrect, i.e., does
	 *                                            not match the block size of the
	 *                                            cipher.
	 * @throws BadPaddingException                This exception is thrown when a
	 *                                            particular padding mechanism is
	 *                                            expected for the input data but
	 *                                            the data is not padded properly.
	 * @throws UnsupportedEncodingException       The Character Encoding is not
	 *                                            supported.
	 */
	public static String decrypt(String encryptedText)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
		// Decode secret key
//        byte [] s = Base64.getDecoder().decode(BIZ_IDENTIFIER.getBytes());
//        byte [] t = Base64.getDecoder().decode(s);
//        String secret = new String(t);
//
//        encryptedText = new String(Base64.getDecoder().decode(encryptedText.getBytes()));
//        String ivStr = encryptedText.substring(0, BLOCK_SIZE);
//        encryptedText = encryptedText.substring(BLOCK_SIZE);
//        byte [] iv = ivStr.getBytes();
//        byte [] key = secret.getBytes();
//        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
//        IvParameterSpec ivspec = new IvParameterSpec(iv);
//        Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
//        cipher.init(Cipher.DECRYPT_MODE,skeySpec,ivspec);
//        byte [] plainTextByte = cipher.doFinal(hexToByte(encryptedText));
//        return new String(plainTextByte,"UTF-8").replaceAll("[\\x00-\\x1f]", "");
		byte[] s = Base64.getDecoder().decode(BIZ_IDENTIFIER.getBytes());
		byte[] t = Base64.getDecoder().decode(s);
		String secret = new String(t);
		System.out.println("decode screen--->" + secret);
		encryptedText = new String(Base64.getDecoder().decode(encryptedText.getBytes()));
		String ivStr = encryptedText.substring(0, BLOCK_SIZE);
		encryptedText = encryptedText.substring(BLOCK_SIZE);
		byte[] iv = ivStr.getBytes();
		byte[] key = secret.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivspec);
		byte[] plainTextByte = cipher.doFinal(hexToByte(encryptedText));

		System.out.println("111 : " + new String(plainTextByte, "UTF-8"));

		// System.out.println("222 : " + Base64.getDecoder().decode(plainTextByte));

		// return Base64.getDecoder().encodeToString((bytesToHex(new byte[8]) +
		// bytesToHex(plainTextByte)).getBytes("UTF-8"));

		return new String(plainTextByte, "UTF-8").replaceAll("[\\x00-\\x1f]", "");

	}

	/**
	 * Encrypt UI.
	 * 
	 * @param message Encrypt any message.
	 * @return Encrypted message.
	 * @throws UnsupportedEncodingException       If encoding is not supported.
	 * @throws NoSuchPaddingException             If padding is illegal.
	 * @throws NoSuchAlgorithmException           If current algorithm is not valid.
	 * @throws InvalidAlgorithmParameterException Invalid algorithm parameter.
	 * @throws InvalidKeyException                Invalid key.
	 * @throws BadPaddingException                Illegal padding.
	 * @throws IllegalBlockSizeException          Illegal block size.
	 */
	public String uiEncrypt(String message)
			throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		String iv = "";
		String r = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < BLOCK_SIZE; i++) {
			iv = iv.concat(String.valueOf(r.charAt((int) Math.floor(Math.random() * r.length()))));
		}
		// Log.d("uiEncrypt", iv);
		byte[] s = Base64.getDecoder().decode(BIZ_IDENTIFIER.getBytes());
		byte[] t = Base64.getDecoder().decode(s);
		String secret = new String(t);
		System.out.println("ENCODE SEcreet-->" + secret);

		SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes(), "AES");
		IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

		Cipher cipher = Cipher.getInstance("AES/CFB/ZeroBytePadding");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivspec);
		byte[] encrypted = cipher.doFinal(message.getBytes());
		// Log.d("uiEncrypt", Base64.encodeToString((iv +
		// bytesToHex(encrypted)).getBytes("UTF-8"),
		// Base64.NO_WRAP));
		return Base64.getEncoder().encodeToString((iv + bytesToHex(encrypted)).getBytes("UTF-8"));

	}

	/*public static String decriptPassword(String secret, String data)
			throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		final int saltInitializer = 8;
		final int keyStartIndex = 0;
		final int keyEndIndex = 32;
		final int ivStartIndex = 32;
		final int ivEndIndex = 48;
		final int saltLength = 8;
		byte[] salt = new byte[saltInitializer];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(salt);

		System.out.println("slat--->"+salt.toString());
		byte[] keyAndIV = deriveKeyAndIV(secret.getBytes(), salt);
		byte[] key = Arrays.copyOfRange(keyAndIV, keyStartIndex, keyEndIndex);
		byte[] iv = Arrays.copyOfRange(keyAndIV, ivStartIndex, ivEndIndex);
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
		IvParameterSpec ivspec = new IvParameterSpec(iv);

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivspec);
		byte[] decripted = cipher.doFinal(data.getBytes());

		byte[] strToEncode;
		strToEncode = new byte[BLOCK_SIZE + decripted.length];

		System.arraycopy(hexToByte(salt.toString()).getBytes("UTF-8"), 0, new byte[BLOCK_SIZE + decripted.length], 0, saltLength);
		System.arraycopy(hexToByte(decripted.toString()).getBytes("UTF-8"), 0, new byte[BLOCK_SIZE + decripted.length],
				BLOCK_SIZE, decripted.length);
		// return Base64.encodeToString((bytesToHex(salt) +
		// bytesToHex(encrypted)).getBytes("UTF-8"), Base64.NO_WRAP);
		return Base64.getDecoder().decode(hexToByte(salt.toString()) + hexToByte(decripted.toString())).getBytes("UTF-8").toString();

		//return data;

	}*/

	/*public static String dectripto(String data) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {

		byte[] s = Base64.getDecoder().decode(BIZ_IDENTIFIER.getBytes());
		byte[] t = Base64.getDecoder().decode(s);
		String secret = new String(t);
		System.out.println("encript secret-->" + secret);
		String encryptedPassword = decriptPassword(secret, data); // take the value from user password edit text
		System.out.println("Encrypted password is: " + encryptedPassword);
		// Log.v(TAG, "Encrypted password is: " + encryptedPassword);
		return encryptedPassword;
		// return null;

	}*/

	
}