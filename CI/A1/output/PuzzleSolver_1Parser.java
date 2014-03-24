// $ANTLR 3.4 /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g 2014-03-24 11:07:43

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PuzzleSolver_1Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR", "EQ", "ESC_SEQ", "HEX_DIGIT", "ID", "OCTAL_ESC", "OP", "UNICODE_ESC", "WS"
    };

    public static final int EOF=-1;
    public static final int CHAR=4;
    public static final int EQ=5;
    public static final int ESC_SEQ=6;
    public static final int HEX_DIGIT=7;
    public static final int ID=8;
    public static final int OCTAL_ESC=9;
    public static final int OP=10;
    public static final int UNICODE_ESC=11;
    public static final int WS=12;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public PuzzleSolver_1Parser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public PuzzleSolver_1Parser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return PuzzleSolver_1Parser.tokenNames; }
    public String getGrammarFileName() { return "/Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g"; }



    // $ANTLR start "grouped_ids"
    // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:6:1: grouped_ids : ( ID )+ ;
    public final void grouped_ids() throws RecognitionException {
        try {
            // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:6:13: ( ( ID )+ )
            // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:6:15: ( ID )+
            {
            // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:6:15: ( ID )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:6:15: ID
            	    {
            	    match(input,ID,FOLLOW_ID_in_grouped_ids28); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "grouped_ids"



    // $ANTLR start "row"
    // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:12:1: row : grouped_ids OP grouped_ids EQ grouped_ids ;
    public final void row() throws RecognitionException {
        try {
            // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:12:6: ( grouped_ids OP grouped_ids EQ grouped_ids )
            // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:12:8: grouped_ids OP grouped_ids EQ grouped_ids
            {
            pushFollow(FOLLOW_grouped_ids_in_row55);
            grouped_ids();

            state._fsp--;


            match(input,OP,FOLLOW_OP_in_row57); 

            pushFollow(FOLLOW_grouped_ids_in_row59);
            grouped_ids();

            state._fsp--;


            match(input,EQ,FOLLOW_EQ_in_row61); 

            pushFollow(FOLLOW_grouped_ids_in_row63);
            grouped_ids();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "row"



    // $ANTLR start "op_row"
    // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:15:1: op_row : OP OP OP ;
    public final void op_row() throws RecognitionException {
        try {
            // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:16:2: ( OP OP OP )
            // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:16:4: OP OP OP
            {
            match(input,OP,FOLLOW_OP_in_op_row74); 

            match(input,OP,FOLLOW_OP_in_op_row76); 

            match(input,OP,FOLLOW_OP_in_op_row78); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "op_row"



    // $ANTLR start "eq_row"
    // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:19:1: eq_row : EQ EQ EQ ;
    public final void eq_row() throws RecognitionException {
        try {
            // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:20:2: ( EQ EQ EQ )
            // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:20:4: EQ EQ EQ
            {
            match(input,EQ,FOLLOW_EQ_in_eq_row89); 

            match(input,EQ,FOLLOW_EQ_in_eq_row91); 

            match(input,EQ,FOLLOW_EQ_in_eq_row93); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "eq_row"



    // $ANTLR start "prog"
    // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:23:1: prog : row op_row row eq_row row ;
    public final void prog() throws RecognitionException {
        try {
            // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:23:7: ( row op_row row eq_row row )
            // /Users/sacry/dev/haw/CI/A1/PuzzleSolver_1.g:23:9: row op_row row eq_row row
            {
            pushFollow(FOLLOW_row_in_prog104);
            row();

            state._fsp--;


            pushFollow(FOLLOW_op_row_in_prog106);
            op_row();

            state._fsp--;


            pushFollow(FOLLOW_row_in_prog108);
            row();

            state._fsp--;


            pushFollow(FOLLOW_eq_row_in_prog110);
            eq_row();

            state._fsp--;


            pushFollow(FOLLOW_row_in_prog112);
            row();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "prog"

    // Delegated rules


 

    public static final BitSet FOLLOW_ID_in_grouped_ids28 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_grouped_ids_in_row55 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_OP_in_row57 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_grouped_ids_in_row59 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQ_in_row61 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_grouped_ids_in_row63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OP_in_op_row74 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_OP_in_op_row76 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_OP_in_op_row78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_eq_row89 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQ_in_eq_row91 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQ_in_eq_row93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_row_in_prog104 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_op_row_in_prog106 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_row_in_prog108 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_eq_row_in_prog110 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_row_in_prog112 = new BitSet(new long[]{0x0000000000000002L});

}