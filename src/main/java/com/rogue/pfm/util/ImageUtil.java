package com.rogue.pfm.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public final class ImageUtil {

	public static byte[] compressImage(final byte[] data) {

		final Deflater deflater = new Deflater();
		deflater.setLevel(Deflater.BEST_COMPRESSION);
		deflater.setInput(data);
		deflater.finish();

		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		final byte[] tmp = new byte[4 * 1024];
		while (!deflater.finished()) {
			final int size = deflater.deflate(tmp);
			outputStream.write(tmp, 0, size);
		}
		try {
			outputStream.close();
		} catch (final Exception e) {
		}

		return outputStream.toByteArray();
	}

	public static byte[] decompressImage(final byte[] data) {
		final Inflater inflater = new Inflater();
		inflater.setInput(data);

		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		final byte[] tmp = new byte[4 * 1024];
		try {
			while (!inflater.finished()) {
				final int count = inflater.inflate(tmp);
				outputStream.write(tmp, 0, count);
			}
			outputStream.close();
		} catch (final Exception exception) {
		}

		return outputStream.toByteArray();
	}
}
