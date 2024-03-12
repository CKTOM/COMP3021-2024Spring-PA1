package hk.ust.comp3021.stmt;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.*;

public class ClassDefStmt extends ASTStmt {
    /*
     * ClassDef(identifier name,
     *         expr* bases,
     *         keyword* keywords,
     *         stmt* body,
     *         expr* decorator_list,...)
     */
    private String name;
    private ArrayList<ASTExpr> bases = new ArrayList<>();
    private ArrayList<ASTKeyWord> keywords = new ArrayList<>();
    private ArrayList<ASTStmt> body = new ArrayList<>();
    private ArrayList<ASTExpr> decoratorList = new ArrayList<>();

    public ClassDefStmt(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.name = node.getAttribute("Name");
        for(XMLNode child : node.getChildByIdx(0).getChildren())
        {
            this.bases.add(ASTExpr.createASTExpr(child));
        }
        for(XMLNode child : node.getChildByIdx(1).getChildren())
        {
            this.keywords.add(new ASTKeyWord(child));
        }
        for(XMLNode child : node.getChildByIdx(2).getChildren())
        {
            this.body.add(ASTStmt.createASTStmt(child));
        }
        this.decoratorList.add(ASTExpr.createASTExpr(node.getChildByIdx(3)));
        for(XMLNode child : node.getChildByIdx(3).getChildren())
        {
            this.decoratorList.add(ASTExpr.createASTExpr(child));
        }
        this.stmtType = StmtType.ClassDef;
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> return_Children_list = new ArrayList<ASTElement>();
        return_Children_list.addAll(this.bases);
        return_Children_list.addAll(this.keywords);
        return_Children_list.addAll(this.body);
        return_Children_list.addAll(this.body);
        return return_Children_list;
    }

    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        int count = 4;
        return count;
    }

    @Override
    public void printByPos(StringBuilder str) {
        // TODO: (Bonus) complete the definition of the method `printByPos`
    }

    /**
     * Attention: You may need to define more methods to update or access the field
     * of the class ASTStmt, i.e., getters or setters Feel free to define more
     * method but remember not
     * (1) removing the fields or methods in our skeleton.
     * (2) changing the type signature of `public` methods
     * (3) changing the modifiers of the fields and methods, e.g., changing a modifier from "private"
     * to "public"
     */
    @Override
    public void yourMethod() {
    }
}
