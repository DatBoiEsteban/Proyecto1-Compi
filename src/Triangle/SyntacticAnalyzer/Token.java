/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int // Se agregan palabra y símbolos léxicos.

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    ARRAY		= 4,
    //BEGIN		= 5,  // Se elimina la palabra en Triángulo extendido.
    CASE        = 5,  // Se  agrega la palabra reservada.
    CONST		= 6,
    CONTINUE    = 7,  // Se  agrega la palabra reservada.
    DO			= 8,
    ELSE		= 9,
    ELSEIF      = 10, // Se  agrega la palabra reservada.
    END			= 11,
    FOR         = 12, // Se  agrega la palabra reservada.
    FROM        = 13, // Se  agrega la palabra reservada.
    FUNC		= 14,
    IF			= 15,
    IN			= 16,
    LEAVE       = 17, // Se  agrega la palabra reservada.
    LET			= 18,
    LOCAL       = 19, // Se  agrega la palabra reservada.
    LOOP        = 20, // Se  agrega la palabra reservada.
    OF			= 21,
    PROC		= 22,
    RECORD		= 23,
    RECURSIVE   = 24, // Se  agrega la palabra reservada.
    SELECT      = 25, // Se  agrega la palabra reservada.
    SKIP        = 26, // Se  agrega la palabra reservada.
    THEN		= 27,
    TO          = 28, // Se  agrega la palabra reservada.
    TYPE		= 29,
    UNTIL       = 30, // Se  agrega la palabra reservada.
    VAR			= 31,
    WHILE		= 32,

    // punctuation...
    DOT			= 33,
    DOUBLEDOT   = 34, //".." Se  agrega la el símbolo léxico.
    COLON		= 35,
    SEMICOLON	= 36,
    COMMA		= 37,
    BECOMES		= 38,
    IS			= 39,
    PIPE        = 40, // "|" Se  agrega la el símbolo léxico.

    // brackets...
    LPAREN		= 41,
    RPAREN		= 42,
    LBRACKET	= 43,
    RBRACKET	= 44,
    LCURLY		= 45,
    RCURLY		= 46,

    // special tokens...
    EOT			= 47,
    ERROR		= 48;

  private static final String[] tokenTable = new String[] { // Se elimina begin y alfabéticamente se incorporan las nuevas palabras reservadas.
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    //"begin",
    "case",
    "const",
    "continue",
    "do",
    "else",
    "elseif",
    "end",
    "for",
    "from",
    "func",
    "if",
    "in",
    "leave",
    "let",
    "local",
    "loop",
    "of",
    "proc",
    "record",
    "recursive",
    "select",
    "skip",
    "then",
    "to",
    "type",
    "until",
    "var",
    "while",
    ".",
    "..",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "|",
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"
  };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

  public static int getLastReservedWord() {
    return lastReservedWord;
  }

}
