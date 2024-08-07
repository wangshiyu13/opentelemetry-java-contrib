/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.contrib.inferredspans.internal.util;

public class ByteUtils {

  private ByteUtils() {}

  public static void putLong(byte[] buffer, int offset, long l) {
    buffer[offset++] = (byte) (l >> 56);
    buffer[offset++] = (byte) (l >> 48);
    buffer[offset++] = (byte) (l >> 40);
    buffer[offset++] = (byte) (l >> 32);
    buffer[offset++] = (byte) (l >> 24);
    buffer[offset++] = (byte) (l >> 16);
    buffer[offset++] = (byte) (l >> 8);
    buffer[offset] = (byte) l;
  }

  public static long getLong(byte[] buffer, int offset) {
    return ((long) buffer[offset] << 56)
        | ((long) buffer[offset + 1] & 0xff) << 48
        | ((long) buffer[offset + 2] & 0xff) << 40
        | ((long) buffer[offset + 3] & 0xff) << 32
        | ((long) buffer[offset + 4] & 0xff) << 24
        | ((long) buffer[offset + 5] & 0xff) << 16
        | ((long) buffer[offset + 6] & 0xff) << 8
        | ((long) buffer[offset + 7] & 0xff);
  }
}
