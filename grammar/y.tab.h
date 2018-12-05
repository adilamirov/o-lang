/* A Bison parser, made by GNU Bison 2.3.  */

/* Skeleton interface for Bison's Yacc-like parsers in C

   Copyright (C) 1984, 1989, 1990, 2000, 2001, 2002, 2003, 2004, 2005, 2006
   Free Software Foundation, Inc.

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2, or (at your option)
   any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program; if not, write to the Free Software
   Foundation, Inc., 51 Franklin Street, Fifth Floor,
   Boston, MA 02110-1301, USA.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* Tokens.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
   /* Put the tokens into the symbol table, so that GDB and other debuggers
      know about them.  */
   enum yytokentype {
     IDENTIFIER = 258,
     INTEGERLITERAL = 259,
     REALLITERAL = 260,
     BOOLEANLITERAL = 261,
     CLASS = 262,
     EXTENDS = 263,
     IS = 264,
     END = 265,
     VAR = 266,
     METHOD = 267,
     THIS = 268,
     WHILE = 269,
     LOOP = 270,
     IF = 271,
     THEN = 272,
     ELSE = 273,
     RETURN = 274,
     LPAREN = 275,
     RPAREN = 276,
     LBRACKET = 277,
     RBRACKET = 278,
     COMMA = 279,
     DOT = 280,
     COLON = 281,
     ASSIGN = 282
   };
#endif
/* Tokens.  */
#define IDENTIFIER 258
#define INTEGERLITERAL 259
#define REALLITERAL 260
#define BOOLEANLITERAL 261
#define CLASS 262
#define EXTENDS 263
#define IS 264
#define END 265
#define VAR 266
#define METHOD 267
#define THIS 268
#define WHILE 269
#define LOOP 270
#define IF 271
#define THEN 272
#define ELSE 273
#define RETURN 274
#define LPAREN 275
#define RPAREN 276
#define LBRACKET 277
#define RBRACKET 278
#define COMMA 279
#define DOT 280
#define COLON 281
#define ASSIGN 282




#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define yystype YYSTYPE /* obsolescent; will be withdrawn */
# define YYSTYPE_IS_DECLARED 1
# define YYSTYPE_IS_TRIVIAL 1
#endif

extern YYSTYPE yylval;

