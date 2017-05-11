package com.example.originalLanguage.compiler.expression;

import com.example.originalLanguage.compiler.Compiler;

import java.util.List;

/**
 * Created by Yuky on 2017/05/11.
 */
public class NumberExpression extends AbstractExpression {
    public void compile(List<Byte> objectCodeList)
            throws Exception {
        double value = getValue().getN();
        byte b = (byte)value;
        objectCodeList.add(Compiler.BIPUSH);
        objectCodeList.add(new Byte(b));
    }
}
