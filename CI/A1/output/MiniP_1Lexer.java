// $ANTLR 3.4 C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g 2014-03-29 14:43:05

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MiniP_1Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int BEGIN=4;
    public static final int BOOL=5;
    public static final int COMMA=6;
    public static final int COMMENT=7;
    public static final int DEF=8;
    public static final int DIGIT=9;
    public static final int END=10;
    public static final int ESC_SEQ=11;
    public static final int EXPONENT=12;
    public static final int FLOAT=13;
    public static final int HEX_DIGIT=14;
    public static final int ID=15;
    public static final int INT=16;
    public static final int LETTER=17;
    public static final int OCTAL_ESC=18;
    public static final int PROGRAM=19;
    public static final int PUNKT_OP=20;
    public static final int RELOP=21;
    public static final int SEMICOL=22;
    public static final int STRICH_OP=23;
    public static final int STRING=24;
    public static final int TYPE=25;
    public static final int UNICODE_ESC=26;
    public static final int WS=27;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public MiniP_1Lexer() {} 
    public MiniP_1Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MiniP_1Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g"; }

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:2:7: ( '(' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:2:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:3:7: ( ')' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:3:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:4:7: ( 'do' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:4:9: 'do'
            {
            match("do"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:5:7: ( 'else' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:5:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:6:7: ( 'fi' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:6:9: 'fi'
            {
            match("fi"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:7:7: ( 'if' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:7:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:8:7: ( 'od' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:8:9: 'od'
            {
            match("od"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:9:7: ( 'print' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:9:9: 'print'
            {
            match("print"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:10:7: ( 'println' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:10:9: 'println'
            {
            match("println"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:11:7: ( 'read(' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:11:9: 'read('
            {
            match("read("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:12:7: ( 'then' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:12:9: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:13:7: ( 'while' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:13:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "DEF"
    public final void mDEF() throws RecognitionException {
        try {
            int _type = DEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:19:5: ( ':=' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:19:7: ':='
            {
            match(":="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEF"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:61:6: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:61:8: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:61:17: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOL"

    // $ANTLR start "PUNKT_OP"
    public final void mPUNKT_OP() throws RecognitionException {
        try {
            int _type = PUNKT_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:65:10: ( ( '*' | '/' ) )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:
            {
            if ( input.LA(1)=='*'||input.LA(1)=='/' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PUNKT_OP"

    // $ANTLR start "STRICH_OP"
    public final void mSTRICH_OP() throws RecognitionException {
        try {
            int _type = STRICH_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:68:11: ( ( '+' | '-' ) )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRICH_OP"

    // $ANTLR start "RELOP"
    public final void mRELOP() throws RecognitionException {
        try {
            int _type = RELOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:71:7: ( ( '=' | '<>' | '<' | '<=' | '>' | '>=' ) )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:71:9: ( '=' | '<>' | '<' | '<=' | '>' | '>=' )
            {
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:71:9: ( '=' | '<>' | '<' | '<=' | '>' | '>=' )
            int alt2=6;
            switch ( input.LA(1) ) {
            case '=':
                {
                alt2=1;
                }
                break;
            case '<':
                {
                switch ( input.LA(2) ) {
                case '>':
                    {
                    alt2=2;
                    }
                    break;
                case '=':
                    {
                    alt2=4;
                    }
                    break;
                default:
                    alt2=3;
                }

                }
                break;
            case '>':
                {
                int LA2_3 = input.LA(2);

                if ( (LA2_3=='=') ) {
                    alt2=6;
                }
                else {
                    alt2=5;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:71:10: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:71:16: '<>'
                    {
                    match("<>"); 



                    }
                    break;
                case 3 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:71:23: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:71:29: '<='
                    {
                    match("<="); 



                    }
                    break;
                case 5 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:71:36: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:71:42: '>='
                    {
                    match(">="); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RELOP"

    // $ANTLR start "PROGRAM"
    public final void mPROGRAM() throws RecognitionException {
        try {
            int _type = PROGRAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:74:10: ( 'program' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:74:12: 'program'
            {
            match("program"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PROGRAM"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:77:8: ( 'begin' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:77:10: 'begin'
            {
            match("begin"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:80:6: ( 'end' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:80:8: 'end'
            {
            match("end"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:83:7: ( ( 'integer' | 'string' | 'real' | 'boolean' ) )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:83:9: ( 'integer' | 'string' | 'real' | 'boolean' )
            {
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:83:9: ( 'integer' | 'string' | 'real' | 'boolean' )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 'i':
                {
                alt3=1;
                }
                break;
            case 's':
                {
                alt3=2;
                }
                break;
            case 'r':
                {
                alt3=3;
                }
                break;
            case 'b':
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:83:10: 'integer'
                    {
                    match("integer"); 



                    }
                    break;
                case 2 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:83:22: 'string'
                    {
                    match("string"); 



                    }
                    break;
                case 3 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:83:33: 'real'
                    {
                    match("real"); 



                    }
                    break;
                case 4 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:83:42: 'boolean'
                    {
                    match("boolean"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "SEMICOL"
    public final void mSEMICOL() throws RecognitionException {
        try {
            int _type = SEMICOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:86:10: ( ';' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:86:16: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMICOL"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:89:10: ( ',' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:89:16: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:93:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:93:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )*
            {
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:93:9: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match('.'); 

            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:93:25: ( '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:96:5: ( ( '0' .. '9' )+ )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:96:7: ( '0' .. '9' )+
            {
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:96:7: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:100:5: ( '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\'' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:100:8: '\\'' ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )* '\\''
            {
            match('\''); 

            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:100:13: ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\\') ) {
                    alt7=1;
                }
                else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '&')||(LA7_0 >= '(' && LA7_0 <= '[')||(LA7_0 >= ']' && LA7_0 <= '\uFFFF')) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:100:15: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:100:25: ~ ( '\\\\' | '\\'' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:103:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | ( 'a' .. 'z' | 'A' .. 'Z' ) | '_' )* )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:103:7: ( 'a' .. 'z' | 'A' .. 'Z' ) ( '0' .. '9' | ( 'a' .. 'z' | 'A' .. 'Z' ) | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:103:29: ( '0' .. '9' | ( 'a' .. 'z' | 'A' .. 'Z' ) | '_' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:107:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:107:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:107:14: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1 >= '\u0000' && LA9_1 <= '.')||(LA9_1 >= '0' && LA9_1 <= '\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0 >= '\u0000' && LA9_0 <= ')')||(LA9_0 >= '+' && LA9_0 <= '\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:107:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            match("*/"); 



            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:110:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:110:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:119:7: ( ( '0' .. '9' ) )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:123:8: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:127:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:127:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:127:22: ( '+' | '-' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='+'||LA10_0=='-') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:127:33: ( '0' .. '9' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:131:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:136:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt12=1;
                    }
                    break;
                case 'u':
                    {
                    alt12=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt12=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:136:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:137:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:138:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:143:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\\') ) {
                int LA13_1 = input.LA(2);

                if ( ((LA13_1 >= '0' && LA13_1 <= '3')) ) {
                    int LA13_2 = input.LA(3);

                    if ( ((LA13_2 >= '0' && LA13_2 <= '7')) ) {
                        int LA13_4 = input.LA(4);

                        if ( ((LA13_4 >= '0' && LA13_4 <= '7')) ) {
                            alt13=1;
                        }
                        else {
                            alt13=2;
                        }
                    }
                    else {
                        alt13=3;
                    }
                }
                else if ( ((LA13_1 >= '4' && LA13_1 <= '7')) ) {
                    int LA13_3 = input.LA(3);

                    if ( ((LA13_3 >= '0' && LA13_3 <= '7')) ) {
                        alt13=2;
                    }
                    else {
                        alt13=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:143:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:144:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:145:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:150:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:150:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:8: ( T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | DEF | BOOL | PUNKT_OP | STRICH_OP | RELOP | PROGRAM | BEGIN | END | TYPE | SEMICOL | COMMA | FLOAT | INT | STRING | ID | COMMENT | WS )
        int alt14=29;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:10: T__28
                {
                mT__28(); 


                }
                break;
            case 2 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:16: T__29
                {
                mT__29(); 


                }
                break;
            case 3 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:22: T__30
                {
                mT__30(); 


                }
                break;
            case 4 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:28: T__31
                {
                mT__31(); 


                }
                break;
            case 5 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:34: T__32
                {
                mT__32(); 


                }
                break;
            case 6 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:40: T__33
                {
                mT__33(); 


                }
                break;
            case 7 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:46: T__34
                {
                mT__34(); 


                }
                break;
            case 8 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:52: T__35
                {
                mT__35(); 


                }
                break;
            case 9 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:58: T__36
                {
                mT__36(); 


                }
                break;
            case 10 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:64: T__37
                {
                mT__37(); 


                }
                break;
            case 11 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:70: T__38
                {
                mT__38(); 


                }
                break;
            case 12 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:76: T__39
                {
                mT__39(); 


                }
                break;
            case 13 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:82: DEF
                {
                mDEF(); 


                }
                break;
            case 14 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:86: BOOL
                {
                mBOOL(); 


                }
                break;
            case 15 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:91: PUNKT_OP
                {
                mPUNKT_OP(); 


                }
                break;
            case 16 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:100: STRICH_OP
                {
                mSTRICH_OP(); 


                }
                break;
            case 17 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:110: RELOP
                {
                mRELOP(); 


                }
                break;
            case 18 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:116: PROGRAM
                {
                mPROGRAM(); 


                }
                break;
            case 19 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:124: BEGIN
                {
                mBEGIN(); 


                }
                break;
            case 20 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:130: END
                {
                mEND(); 


                }
                break;
            case 21 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:134: TYPE
                {
                mTYPE(); 


                }
                break;
            case 22 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:139: SEMICOL
                {
                mSEMICOL(); 


                }
                break;
            case 23 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:147: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 24 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:153: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 25 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:159: INT
                {
                mINT(); 


                }
                break;
            case 26 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:163: STRING
                {
                mSTRING(); 


                }
                break;
            case 27 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:170: ID
                {
                mID(); 


                }
                break;
            case 28 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:173: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 29 :
                // C:\\Users\\Swaneet\\github\\haw\\CI\\A1\\MiniP_1.g:1:181: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\3\uffff\11\26\1\uffff\1\27\2\uffff\2\26\2\uffff\1\53\4\uffff\1"+
        "\54\2\26\1\57\1\26\1\61\1\26\1\63\5\26\1\uffff\3\26\3\uffff\1\26"+
        "\1\76\1\uffff\1\26\1\uffff\1\26\1\uffff\11\26\1\113\1\uffff\5\26"+
        "\1\121\1\122\1\123\4\26\1\uffff\1\123\1\26\1\132\1\26\4\uffff\1"+
        "\134\1\135\4\26\1\uffff\1\26\2\uffff\1\26\2\121\1\144\1\145\1\121"+
        "\2\uffff";
    static final String DFA14_eofS =
        "\146\uffff";
    static final String DFA14_minS =
        "\1\11\2\uffff\1\157\1\154\1\141\1\146\1\144\1\162\1\145\2\150\1"+
        "\uffff\1\52\2\uffff\1\145\1\164\2\uffff\1\56\4\uffff\1\60\1\163"+
        "\1\144\1\60\1\154\1\60\1\164\1\60\1\151\1\141\1\145\1\165\1\151"+
        "\1\uffff\1\147\1\157\1\162\3\uffff\1\145\1\60\1\uffff\1\163\1\uffff"+
        "\1\145\1\uffff\1\156\1\147\1\144\1\156\1\145\1\154\1\151\1\154\1"+
        "\151\1\60\1\uffff\1\145\1\147\1\164\1\162\1\50\3\60\1\145\1\156"+
        "\1\145\1\156\1\uffff\1\60\1\145\1\60\1\141\4\uffff\2\60\1\141\1"+
        "\147\1\162\1\156\1\uffff\1\155\2\uffff\1\156\5\60\2\uffff";
    static final String DFA14_maxS =
        "\1\172\2\uffff\1\157\1\156\1\151\1\156\1\144\1\162\1\145\1\162\1"+
        "\150\1\uffff\1\52\2\uffff\1\157\1\164\2\uffff\1\71\4\uffff\1\172"+
        "\1\163\1\144\1\172\1\154\1\172\1\164\1\172\1\157\1\141\1\145\1\165"+
        "\1\151\1\uffff\1\147\1\157\1\162\3\uffff\1\145\1\172\1\uffff\1\163"+
        "\1\uffff\1\145\1\uffff\1\156\1\147\1\154\1\156\1\145\1\154\1\151"+
        "\1\154\1\151\1\172\1\uffff\1\145\1\147\1\164\1\162\1\50\3\172\1"+
        "\145\1\156\1\145\1\156\1\uffff\1\172\1\145\1\172\1\141\4\uffff\2"+
        "\172\1\141\1\147\1\162\1\156\1\uffff\1\155\2\uffff\1\156\5\172\2"+
        "\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\11\uffff\1\15\1\uffff\1\20\1\21\2\uffff\1\26\1"+
        "\27\1\uffff\1\32\1\33\1\17\1\35\15\uffff\1\34\3\uffff\1\30\1\31"+
        "\1\3\2\uffff\1\5\1\uffff\1\6\1\uffff\1\7\12\uffff\1\24\14\uffff"+
        "\1\4\4\uffff\1\12\1\25\1\13\1\16\6\uffff\1\10\1\uffff\1\14\1\23"+
        "\6\uffff\1\11\1\22";
    static final String DFA14_specialS =
        "\146\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\30\2\uffff\1\30\22\uffff\1\30\6\uffff\1\25\1\1\1\2\1\27\1"+
            "\16\1\23\1\16\1\uffff\1\15\12\24\1\14\1\22\3\17\2\uffff\32\26"+
            "\6\uffff\1\26\1\20\1\26\1\3\1\4\1\5\2\26\1\6\5\26\1\7\1\10\1"+
            "\26\1\11\1\21\1\12\2\26\1\13\3\26",
            "",
            "",
            "\1\31",
            "\1\32\1\uffff\1\33",
            "\1\35\7\uffff\1\34",
            "\1\36\7\uffff\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43\11\uffff\1\44",
            "\1\45",
            "",
            "\1\46",
            "",
            "",
            "\1\47\11\uffff\1\50",
            "\1\51",
            "",
            "",
            "\1\52\1\uffff\12\24",
            "",
            "",
            "",
            "",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\55",
            "\1\56",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\60",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\62",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\64\5\uffff\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "",
            "",
            "\1\75",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "",
            "\1\77",
            "",
            "\1\100",
            "",
            "\1\101",
            "\1\102",
            "\1\103\7\uffff\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\130",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\13\26\1\131\16\26",
            "\1\133",
            "",
            "",
            "",
            "",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "",
            "\1\142",
            "",
            "",
            "\1\143",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | DEF | BOOL | PUNKT_OP | STRICH_OP | RELOP | PROGRAM | BEGIN | END | TYPE | SEMICOL | COMMA | FLOAT | INT | STRING | ID | COMMENT | WS );";
        }
    }
 

}