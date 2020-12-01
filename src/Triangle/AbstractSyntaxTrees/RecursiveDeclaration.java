package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RecursiveDeclaration extends Declaration{
    public RecursiveDeclaration(Declaration d1AST, Declaration d2AST, SourcePosition sp) {
        super(sp);
        D1 = d1AST;
        D2 = d2AST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRecursiveDeclaration(this, o);
    }
    public Declaration D1, D2;
}
