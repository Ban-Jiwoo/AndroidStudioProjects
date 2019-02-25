package edu.andrews.cptr252.banjiwoo.quoteoftheday;

public class Quote {

    /** Reference to quote ext */
    private int mQuote;

    /** Reference to quote's author */
    private int mAuthor;

    /** Reference to author's fact */

    private int mAuthorFact;

    /** Reference to image */

    private int mImage;


    /**
     * Create a new quote
     * @param quote     Resource id for quote text.
     * @param author    Resource id ofr quote author.
     * @param authorFact Resuorce id for fact about author
     * @Param image Resuorce id for each quote
     */
    public Quote(int quote, int author, int authorFact, int image) {
        mQuote = quote;
        mAuthor = author;
        mAuthorFact = authorFact;
        mImage = image;
    }

    public int getQuote() {return mQuote;}
    public void setQuote(int quote) { mQuote = quote;}
    public int getAuthor() { return mAuthor;}
    public void setAuthor(int author) { mAuthor = author;}
    public int getAuthorFact() {return mAuthorFact;}
    public void setAuthorFact(int mAuthorFact) { this.mAuthorFact = mAuthorFact;}
    public int getmImage() {return mImage;}
    public void setmImage(int image) {mImage = image;}

}
