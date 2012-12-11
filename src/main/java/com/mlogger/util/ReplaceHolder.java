package com.mlogger.util;

public final class ReplaceHolder {
	
	private static final char OPEN_BRACE    = '{';
	private static final char CLOSE_BRACE   = '}';
	private static final String BLANK_SPACE = "" ;
	
	private ReplaceHolder() {
	}
	
    public static String replaceArgs(String source, Object... params) {
		if (source == null) {
			throw new NullPointerException("source");
		}
		if (params == null || params.length == 0) {
            return source;
        }

        StringBuilder result = new StringBuilder(source);
        StringBuilder temp = new StringBuilder();
        Object param   = null;
        int startIndex = 0;
        int endIndex   = 0;

        for (int count = 0; count < params.length; count++) {
            param = params[count];

            temp.delete(0, temp.length());
            temp.append(OPEN_BRACE);
            temp.append(count);
            temp.append(CLOSE_BRACE);

            while (true) {
                startIndex = result.indexOf(temp.toString(), 0);
                if (startIndex == -1) {
                    break;
                }
                endIndex = startIndex + temp.length();
                result.replace(startIndex, endIndex,
                        param == null ? BLANK_SPACE : param.toString());
            }

            startIndex = 0;
            endIndex = 0;
        }

        return result.toString();
	}

}
