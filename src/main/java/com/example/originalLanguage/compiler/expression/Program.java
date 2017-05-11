package com.example.originalLanguage.compiler.expression;

import java.util.List;

/**
 * Created by Yuky on 2017/05/11.
 */
public class Program extends AbstractExpression {
    public void add(AbstractExpression node) {
        getChildren().add(node);
    }
    public void compile(List<Byte> objectCodeList)
            throws Exception {
        List<AbstractExpression> children = getChildren();
        AbstractExpression n = children.get(0);
        if (n instanceof Expression ||
                n instanceof Term ||
                n instanceof NumberExpression) {
            n.compile(objectCodeList);
        } else {
            throw new Exception();
        }
    }
}

