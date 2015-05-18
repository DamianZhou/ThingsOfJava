package com.demo.bit;


public class UnSignedValue {
	public static int getUnsignedByte (byte data){      //将data字节型数据转换为0~255 (0xFF 即BYTE)。
			return data&0x0FF;
	}

	public static int getUnsignedShort (short data){      //将data字节型数据转换为0~65535 (0xFFFF 即 WORD)。
		return data&0x0FFFF;
	}

	public static long getUnsignedInt (int data){     //将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)。
		return data&0x0FFFFFFFFl;	//强制适用 long 来表示
	}
	
	
	public static void main(String[] args) {
		byte a = -128; // -1 表示最大255, -128 表示128    （从最小的数开始）
		short b = -1;
		int c = -1;
		System.out.println(getUnsignedByte(a));
		
		System.out.println(getUnsignedShort(b));

		
		System.out.println(getUnsignedInt(c));

	}

}
