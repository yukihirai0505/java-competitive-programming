package com.example.originalLanguage.compiler;

import com.example.originalLanguage.compiler.expression.AbstractExpression;
import com.example.originalLanguage.compiler.parser.Parser;
import com.example.originalLanguage.compiler.scanner.Scanner;
import com.example.originalLanguage.compiler.scanner.Token;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuky on 2017/05/11.
 */
public class Compiler {
    public static final Byte IADD = new Byte((byte)96);
    public static final Byte ISUB = new Byte((byte)100);
    public static final Byte IMUL = new Byte((byte)104);
    public static final Byte IDIV = new Byte((byte)108);
    public static final Byte BIPUSH = new Byte((byte)16);
    public static final Byte PRINT = new Byte((byte)-48);
    public void compile(String fieldName) throws Exception {
        Scanner scanner = new Scanner(fieldName);
        List<Token> tokenList = scanner.createTokenList();
        Parser parser = new Parser();
        AbstractExpression ae = parser.execute(tokenList);
        List<Byte> objectCodeList = new ArrayList<>();
        ae.print(0);
        ae.compile(objectCodeList);
        objectCodeList.add(PRINT);
        byte[] code = new byte[objectCodeList.size()];
        System.out.println("--");
        for (int i = 0; i < code.length; i++) {
            code[i] = objectCodeList.get(i).byteValue();
            System.out.println(code[i] + "|");
        }
        System.out.println("\n--");
        try {
            write("a.svm", code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void write(String filename, byte[] code) throws IOException {
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(new File(filename));
            fo.write(code);
        } finally {
            if (fo != null) {
                fo.close();
            }
        }
    }
}
