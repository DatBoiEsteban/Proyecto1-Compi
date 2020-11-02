package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class InitializedVarDeclaration extends Declaration {
    public InitializedVarDeclaration(Identifier id, Expression ex, SourcePosition thePosition) {
        super(thePosition);
        this.I = id;
        this.E = ex;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitInitializedVarDeclaration(this, o);
    }
    public Identifier I;
    public Expression E;
}
