/**
 * Represents a chessboard state. Each chess square is represented by a single
 * bit, therefore allowing for extremely compact and fast operations and
 * queries to be performed. Bitboards may be used to represent the location of
 * pieces, permissible moves, or as a mask to perform queries.
 * Bitboards are immutable and thread safe. Operations on bitboards return a
 * new bitboard representing the result. Bitboards are stored in ROW MAJOR
 * format, starting at A1 (bottom left) and ending at H8 (top right).
 * White plays on bottom, A1 to H2, black from A7 to H8.
 */
public class BitBoard {

    public static final BitBoard EMPTY_BOARD = new BitBoard(0);
    public static final BitBoard FULL_BOARD = new BitBoard(Long.MAX_VALUE);
    public static final BitBoard BOTTOM_HALF = new BitBoard(0x00000000FFFFFFFFL);
    public static final BitBoard TOP_HALF = new BitBoard(0xFFFFFFFF00000000L);
    public static final BitBoard TOP_LEFT_QUAD = new BitBoard(0x0F0F0F0F00000000L);
    public static final BitBoard TOP_RIGHT_QUAD = new BitBoard(0xF0F0F0F000000000L);
    public static final BitBoard BOT_LEFT_QUAD = new BitBoard(0x000000000F0F0F0FL);
    public static final BitBoard BOT_RIGHT_QUAD = new BitBoard(0x0000000000F0F0F0L);

    private final long bits;
    private int cachedHits;

    private BitBoard(long bits) {
        this.bits = bits;
        cachedHits = Long.bitCount(bits);
    }

    /**
     * Returns whether there are any entries in the bitboard. This can be used
     * to quickly determine if there valid moves, if any pieces still exist,
     * etc.
     */
    public boolean hasHits() {
        return bits != 0;
    }

    /**
     * Returns the number of entries in the bitboard, ie number of pieces,
     * valid moves, etc.
     */
    public int hits() {
        return cachedHits;
    }

    /**
     * Computes the intersection of two boards: the squares that exist in
     * both bitboards.
     * <p>
     * Computes logical AND on the bitboards.
     */
    public BitBoard intersection(BitBoard board) {
        return new BitBoard(this.bits & board.bits);
    }

    public static BitBoard intersection(BitBoard... boards) {
        long accum = 0L;
        for (BitBoard board : boards) {
            accum &= board.bits;
        }
        return new BitBoard(accum);
    }

    /**
     * Computes the union of two boards: the squares returned are the
     * squares in either board.
     * <p>
     * Computes logical OR on the bitboards.
     */
    public BitBoard union(BitBoard board) {
        return new BitBoard(this.bits | board.bits);
    }

    public static BitBoard union(BitBoard... boards) {
        long accum = 0L;
        for (BitBoard board : boards) {
            accum |= board.bits;
        }
        return new BitBoard(accum);
    }

    /**
     * Computes the inverse of the board - empty squares turn into occupied
     * squares and occupied squares turn into occupied squares.
     */
    public BitBoard invert() {
        return new BitBoard(~bits);
    }

    /**
     * Gets the value at a given board location.
     * Rank is the row, as normal.
     * File is the column, where column A is 0, B is 1, etc.
     */
    public boolean get(int rank, int file) {
        //  location is file + (rank * 8)
        return ((1 << (file + (rank * 8))) & bits) == 1;
    }

    /**
     * Shifts a bitboard over by files and ranks. Squares that are shifted out
     * of the board are lost, and empty spaces are moved in the other side.
     */
    public BitBoard shift(int ranks, int files) {
        BitBoard board = shiftVertically(ranks);
        //  shift horizontally
        return board;
    }


    public BitBoard shiftVertically(int ranks) {
        if (ranks == 0) {
            return this;
        }
        if (ranks < 0) {
            return new BitBoard(bits >>> -ranks);
        } else {
            return new BitBoard(bits << ranks);
        }
    }

    public BitBoard shiftHorizontally(int files) {
        if (files == 0) {
            return this;
        }
        if (files > 0) {
            //  Apply the shift per-row
            long result = 0;
            for (int i = 0; i < 8; i++) {
                int b = i * 8;
                int rank = (int) ((bits >> b) & 0xFF) >>> files;
                result |= (rank << b);
            }
            return new BitBoard(result);
        } else {
            long result = 0;
            for (int i = 0; i < 8; i++) {
                int b = i * 8;
                int rank = (int) ((bits << b) & 0xFF) >> -files;
                result |= (rank << b);
            }
            return new BitBoard(result);
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 64; i++) {
            int bit = (int) ((bits >> i) & 1);
            builder.append(bit);
            if(i % 8 == 0) {
                builder.append('\n');
            }
        }
        return builder.toString();
    }

    /**
     * Creates a bitboard with one entry at (file, rank).
     * File is the column, where column A is 0, B is 1, etc.
     * Rank is the row, as normal.
     */
    public static BitBoard single(int file, int rank) {
        return new BitBoard(1 << (file + (rank * 8)));
    }

}
