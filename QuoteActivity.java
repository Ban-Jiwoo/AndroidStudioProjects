package edu.andrews.cptr252.banjiwoo.quoteoftheday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Main activity for the application
 * Displays a series of quites.
 */
public class QuoteActivity extends AppCompatActivity {

    /** Key for fact about author stored in Intent sent to AuthorFactActivity. */
    public static final String EXTRA_AUTHOR_FACT = "edu.andrews.cptr252.rlsummerscales.quoteoftheday.author_fact";
    private static final String KEY_QUOTE_INDEX = "quoteIndex";

    /** ImageView used to display inspirational image */
    private ImageView mImageView;
    private TextView mQuoteTextView;
    private TextView mAuthorTextView;
    private Button mNextButton;


    /** quotes, authors, facts, and images */
    private Quote[] mQuoteList = new Quote[]{
            new Quote(R.string.quote_text_0, R.string.quote_author_0,R.string.author_fact_0,R.drawable.pic),
            new Quote(R.string.quote_text_1, R.string.quote_author_1,R.string.author_fact_1,R.drawable.mountain),
            new Quote(R.string.quote_text_2, R.string.quote_author_2,R.string.author_fact_2,R.drawable.myjourney),
            new Quote(R.string.quote_text_3, R.string.quote_author_3,R.string.author_fact_3,R.drawable.nature),
            new Quote(R.string.quote_text_4, R.string.quote_author_4,R.string.author_fact_4,R.drawable.jiwoo)
    };

    private int mCurrentIndex = 0;

    /**
     * Remember the current quote when the activity is destroyed
     * @param savedInstanceState Bundle used for saving identity of current quote
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_QUOTE_INDEX, mCurrentIndex);
    }


    /** Launch activity to display author fact */
    private void displayAuthorFact(){
        Intent i = new Intent(QuoteActivity.this, AuthorFactActivity.class);

        i.putExtra(EXTRA_AUTHOR_FACT, mQuoteList[mCurrentIndex].getAuthorFact());

        startActivity(i);
    }

    /** Display the quote at the current index */
    private void updateQuote() {
        int quote = mQuoteList[mCurrentIndex].getQuote();
        int author = mQuoteList[mCurrentIndex].getAuthor();
        int image = mQuoteList[mCurrentIndex].getmImage();

        mQuoteTextView.setText(quote);
        mAuthorTextView.setText(author);
        mImageView.setImageResource(image);
    }

    /**
     * Setup and inflate layout.
     * @param savedInstanceState Previously saved Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        // Re-display the same quote we were on when activity destroyed
        if (savedInstanceState !=null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_QUOTE_INDEX);
        }

        // Display image
        mImageView = findViewById(R.id.imageView);
        int image = mQuoteList[mCurrentIndex].getmImage();
        mImageView.setImageResource(image);


        mQuoteTextView = findViewById(R.id.quoteTextView);
        int quote = mQuoteList[mCurrentIndex].getQuote();

        mQuoteTextView.setText(quote);
        mQuoteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAuthorFact();
            }
        });


        mAuthorTextView = findViewById(R.id.authorTextView);
        int author = mQuoteList[mCurrentIndex].getAuthor();
        mAuthorTextView.setText(author);
        mAuthorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAuthorFact();
            }
        });


        mNextButton = findViewById(R.id.nextbutton);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex++;
                if (mCurrentIndex == mQuoteList.length) {
                    mCurrentIndex = 0;
            }
            updateQuote();
        }
        });
    }


}
