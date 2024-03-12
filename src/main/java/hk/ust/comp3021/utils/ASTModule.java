package hk.ust.comp3021.utils;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.stmt.*;
import java.util.*;


public class ASTModule extends ASTElement {
    // Module(stmt* body, ...)
    private ArrayList<ASTStmt> body;
    private String astID;

    public ASTModule(XMLNode node, String astID) {
        this.astID = astID;

        this.body = new ArrayList<>();
        for (XMLNode bodyNode : node.getChildByIdx(0).getChildren()) {
            this.body.add(ASTStmt.createASTStmt(bodyNode));
        }
    }

    /*
    * Find all AST node whose class type is `FunctionDefStmt` shown in the AST
    * Hints: you need to traverse all the nodes in AST and check its class type.
    * We have prepared the method `getChildren` for you to ease the traversal.
    * You may need to remove the `return null` in the skeleton.
    * */
    public ArrayList<FunctionDefStmt> getAllFunctions() {
        // TODO: complete the definition of the method `getAllFunctions`
        ArrayList<FunctionDefStmt> return_Func_list = new ArrayList<FunctionDefStmt>();
        for(ASTElement node : this.body)
        {
            travel_all_node_for_func(node , return_Func_list);
        }
        return return_Func_list;
    }

    /*
     * Find all operators whose class type is `ASTEnumOp` shown in the AST.
     * Hints: We have prepared the method `getChildren` for you to ease the traversal.
     * But ASTEnumOp is not regarded as children node in AST Tree.
     * To find all operators, you need to first find the nodes whose types are BinOpExpr, BoolOpExpr, etc.
     * Then, you obtain their operators by accessing field `op`.
     * Further, Ctx_Store, Ctx_Load and Ctx_Del are not operators as well.
     * You may need to remove the `return null` in the skeleton.
     * */
    public ArrayList<ASTEnumOp> getAllOperators() {
        // TODO: complete the definition of the method `getAllOperators`
        ArrayList<ASTEnumOp> return_Op_list = new ArrayList<ASTEnumOp>();
        for (ASTElement child : this.body)
        {
            travel_all_node_for_op(child , return_Op_list);
        }
        return return_Op_list;
    }

    /*
     * Find all AST node shown in the AST
     * Hints: you need to traverse all the nodes in AST.
     * You may need to remove the `return null` in the skeleton.
     * */
    public ArrayList<ASTElement> getAllNodes() {
        // TODO: complete the definition of the method `getAllNodes`
        ArrayList<ASTElement> return_node_list = new ArrayList<ASTElement>();
        for(ASTElement child : this.body)
        {
            travel_all_node(child , return_node_list);
        }
        return return_node_list;
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> return_Children_list = new ArrayList<>();
        return_Children_list.addAll(this.body);
        return return_Children_list;
    }

    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        int count = this.body.size();
        for(ASTStmt child : this.body)
        {
            count += child.countChildren();
        }
        return count;
    }

    @Override
    public void printByPos(StringBuilder str) {
        // TODO: (Bonus) complete the definition of the method `printByPos`
    }

    public String getASTID() {
        return astID;
    }

    @Override
    public String getNodeType() {
        return "Module";
    }

    /**
     * Attention: You may need to define more methods to update or access the field of the class `User`
     * Feel free to define more method but remember not
     * (1) removing the fields or methods in our skeleton.
     * (2) changing the type signature of `public` methods
     * (3) changing the modifiers of the fields and methods, e.g., changing a modifier from "private" to "public"
     */
    public void travel_all_node_for_func(ASTElement node , ArrayList<FunctionDefStmt> return_list) {
        if (node == null)
        {
            return;
        }
        if(node.getNodeType().equals("FunctionDef"))
        {
            return_list.add((FunctionDefStmt)node);
        }
        ArrayList<ASTElement> child = node.getChildren();
        if(child != null)
        {
            for(ASTElement children : child)
            {
                travel_all_node_for_func(children , return_list);
            }
        }
    }
    public void travel_all_node(ASTElement node , ArrayList<ASTElement> return_list)
    {
        if (node == null)
        {
            return;
        }
        return_list.add(node);
        ArrayList<ASTElement> child = node.getChildren();
        if(child != null)
        {
            for(ASTElement children : child)
            {
                travel_all_node(children , return_list);
            }
        }
    }
    public void travel_all_node_for_op (ASTElement node, ArrayList<ASTEnumOp> return_list)
    {
        if (node == null)
        {
            return;
        }
        ArrayList<String> exprtype = new ArrayList<>(Arrays.asList("BoolOp", "BinOp", "UnaryOp", "Compare"));
        if(exprtype.contains(node.getNodeType()))
        {
            switch (node.getNodeType())
            {
                case"BoolOp":
                    return_list.add(((BoolOpExpr)node).returnop());
                    break;
                case"BinOp":
                    return_list.add(((BinOpExpr)node).returnop());
                    break;
                case"UnaryOp":
                    return_list.add(((UnaryOpExpr)node).returnop());
                    break;
                case"Compare":
                    return_list.addAll(((CompareExpr)node).returnop());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported Type name: " + node.getNodeType());
            }
        }
        ArrayList<ASTElement> child = node.getChildren();
        if(child != null)
        {
            for(ASTElement children : child)
            {
                travel_all_node_for_op(children, return_list);
            }
        }
    }
}
