package com.example.compiler.expression;

import com.example.compiler.Compiler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuky on 2017/05/11.
 */
public class Expression extends AbstractExpression {
    public void add(AbstractExpression node) {
        getChildren().add(node);
    }
    public void compile(List<Byte> objectCodeList)
            throws Exception {
        ArrayList children = getChildren();
        AbstractExpression leftOperand =
                (AbstractExpression)children.get(0);
        leftOperand.compile(objectCodeList);
        if (children.size() > 1) {
            AbstractExpression rightOperand =
                    (AbstractExpression)children.get(1);
            rightOperand.compile(objectCodeList);
            if ("+".equals(getValue().getS())) {
                objectCodeList.add(Compiler.IADD);
            } else if ("-".equals(getValue().getS())) {
                objectCodeList.add(Compiler.ISUB);
            }
        }
    }
}
