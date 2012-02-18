package com.packtpub.kitchendroid;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends Activity {
	private Button[] buttons;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		initQuestionScreen();
	}

	private static int getQuestionID(final Resources res, final int index) {
		final String[] questions = res.getStringArray(R.array.questions);

		return res.getIdentifier(questions[index], "array",
				"com.packtpub.kitchendroid");
	}

	private int getQuestionIndex() {
		return getIntent().getIntExtra("KitchenDroid.Question", 0);
	}
	
	private void initQuestionScreen() {
		TextView question = (TextView)findViewById(R.id.question);
		ViewGroup answers = (ViewGroup)findViewById(R.id.answers);
		Resources resources = getResources();
		
		int questionID = getQuestionID(resources, getQuestionIndex());
		String[] questionData = resources.getStringArray(questionID);
		
		question.setText(questionData[0]);
		
		int answerCount = questionData.length - 1;
		buttons = new Button[answerCount];
		
		for (int i = 0; i < answerCount; i++) {
			String answer = questionData[i + 1];
			
			Button button = new Button(this);
			button.setText(answer);
			
			answers.addView(button);
			buttons[i] = button;
		}
	}
}