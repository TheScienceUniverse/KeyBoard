package dev.the01guy.keyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class KeyboardView extends RelativeLayout implements View.OnTouchListener {
	private TextView key_a, key_b, key_c, key_d, key_e, key_f, key_g, key_h, key_i, key_j, key_k, key_l, key_m, key_n, key_o, key_p, key_q, key_r, key_s, key_t, key_u, key_v, key_w, key_x, key_y, key_z;
	private TextView key_function_1, key_function_2, key_function_3, key_function_4, key_function_5, key_function_6, key_function_7, key_function_8, key_function_9, key_function_10, key_function_11, key_function_12;
	private TextView key_empty_0, key_left_function, key_left_alt, key_right_alt, key_right_function;
	private LinearLayout key_acute_tilde, key_one_exclamation, key_two_ampersat, key_three_octothrope, key_four_dollar, key_five_percent, key_six_circumflex, key_seven_ampersand, key_eight_asterisk, key_nine_open_parenthesis, key_zero_close_parenthesis, key_hyphen_underscore, key_equal_plus, key_open_bracket_open_brace, key_close_bracket_close_brace, key_backslash_pipe, key_semicolon_colon, key_apostrophe_quotation, key_comma_lesser_than, key_period_greater_than, key_forward_slash_question;
	private ImageView key_escape, key_backspace, key_tab, key_capslock, key_enter, key_left_shift, key_right_shift, key_left_control, key_spacebar, key_search, key_menu, key_right_control;

	private char characterOn;
	private boolean shiftOn = false;
	private boolean controlOn = false;
	private boolean functionOn = false;

	List<KeyData> keyData = new ArrayList<>();



	public KeyboardView(Context context) {
		super(context);
		this.setup();
	}

	public KeyboardView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		this.setup();
	}

	public KeyboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.setup();
	}

	private void setup() {
		this.setupElements();
		this.setupKeys();
		// this.setupListeners();
	}

	private void setupElements() {
		this.key_a = findViewById (R.id.key_a);
		this.key_b = findViewById (R.id.key_b);
		this.key_c = findViewById (R.id.key_c);
		this.key_d = findViewById (R.id.key_d);
		this.key_e = findViewById (R.id.key_e);
		this.key_f = findViewById (R.id.key_f);
		this.key_g = findViewById (R.id.key_g);
		this.key_h = findViewById (R.id.key_h);
		this.key_i = findViewById (R.id.key_i);
		this.key_j = findViewById (R.id.key_j);
		this.key_k = findViewById (R.id.key_k);
		this.key_l = findViewById (R.id.key_l);
		this.key_m = findViewById (R.id.key_m);
		this.key_n = findViewById (R.id.key_n);
		this.key_o = findViewById (R.id.key_o);
		this.key_p = findViewById (R.id.key_p);
		this.key_q = findViewById (R.id.key_q);
		this.key_r = findViewById (R.id.key_r);
		this.key_s = findViewById (R.id.key_s);
		this.key_t = findViewById (R.id.key_t);
		this.key_u = findViewById (R.id.key_u);
		this.key_v = findViewById (R.id.key_v);
		this.key_w = findViewById (R.id.key_w);
		this.key_x = findViewById (R.id.key_x);
		this.key_y = findViewById (R.id.key_y);
		this.key_z = findViewById (R.id.key_z);
		this.key_function_1 = findViewById (R.id.key_function_1);
		this.key_function_2 = findViewById (R.id.key_function_2);
		this.key_function_3 = findViewById (R.id.key_function_3);
		this.key_function_4 = findViewById (R.id.key_function_4);
		this.key_function_5 = findViewById (R.id.key_function_5);
		this.key_function_6 = findViewById (R.id.key_function_6);
		this.key_function_7 = findViewById (R.id.key_function_7);
		this.key_function_8 = findViewById (R.id.key_function_8);
		this.key_function_9 = findViewById (R.id.key_function_9);
		this.key_function_10 = findViewById (R.id.key_function_10);
		this.key_function_11 = findViewById (R.id.key_function_11);
		this.key_function_12 = findViewById (R.id.key_function_12);
		this.key_empty_0 = findViewById (R.id.key_empty_0);
		this.key_left_function = findViewById (R.id.key_left_function);
		this.key_left_alt = findViewById (R.id.key_left_alt);
		this.key_right_alt = findViewById (R.id.key_right_alt);
		this.key_right_function = findViewById (R.id.key_right_function);
		this.key_acute_tilde = findViewById (R.id.key_acute_tilde);
		this.key_one_exclamation = findViewById (R.id.key_one_exclamation);
		this.key_two_ampersat = findViewById (R.id.key_two_ampersat);
		this.key_three_octothrope = findViewById (R.id.key_three_octothrope);
		this.key_four_dollar = findViewById (R.id.key_four_dollar);
		this.key_five_percent = findViewById (R.id.key_five_percent);
		this.key_six_circumflex = findViewById (R.id.key_six_circumflex);
		this.key_seven_ampersand = findViewById (R.id.key_seven_ampersand);
		this.key_eight_asterisk = findViewById (R.id.key_eight_asterisk);
		this.key_nine_open_parenthesis = findViewById (R.id.key_nine_open_parenthesis);
		this.key_zero_close_parenthesis = findViewById (R.id.key_zero_close_parenthesis);
		this.key_hyphen_underscore = findViewById (R.id.key_hyphen_underscore);
		this.key_equal_plus = findViewById (R.id.key_equal_plus);
		this.key_open_bracket_open_brace = findViewById (R.id.key_open_bracket_open_brace);
		this.key_close_bracket_close_brace = findViewById (R.id.key_close_bracket_close_brace);
		this.key_backslash_pipe = findViewById (R.id.key_backslash_pipe);
		this.key_semicolon_colon = findViewById (R.id.key_semicolon_colon);
		this.key_apostrophe_quotation = findViewById (R.id.key_apostrophe_quotation);
		this.key_comma_lesser_than = findViewById (R.id.key_comma_lesser_than);
		this.key_period_greater_than = findViewById (R.id.key_period_greater_than);
		this.key_forward_slash_question = findViewById (R.id.key_forward_slash_question);
		this.key_escape = findViewById (R.id.key_escape);
		this.key_backspace = findViewById (R.id.key_backspace);
		this.key_tab = findViewById (R.id.key_tab);
		this.key_capslock = findViewById (R.id.key_capslock);
		this.key_enter = findViewById (R.id.key_enter);
		this.key_left_shift = findViewById (R.id.key_left_shift);
		this.key_right_shift = findViewById (R.id.key_right_shift);
		this.key_left_control = findViewById (R.id.key_left_control);
		this.key_spacebar = findViewById (R.id.key_spacebar);
		this.key_search = findViewById (R.id.key_search);
		this.key_menu = findViewById (R.id.key_menu);
		this.key_right_control = findViewById (R.id.key_right_control);
	}

	private void setupKeys() {
		this.keyData.add (new KeyData(R.id.key_a, "key_a", "character", '\u0061', '\u0041'));
		this.keyData.add (new KeyData(R.id.key_b, "key_b", "character", '\u0062', '\u0042'));
		this.keyData.add (new KeyData(R.id.key_c, "key_c", "character", '\u0063', '\u0043'));
		this.keyData.add (new KeyData(R.id.key_d, "key_d", "character", '\u0064', '\u0044'));
		this.keyData.add (new KeyData(R.id.key_e, "key_e", "character", '\u0065', '\u0045'));
		this.keyData.add (new KeyData(R.id.key_f, "key_f", "character", '\u0066', '\u0046'));
		this.keyData.add (new KeyData(R.id.key_g, "key_g", "character", '\u0067', '\u0047'));
		this.keyData.add (new KeyData(R.id.key_h, "key_h", "character", '\u0068', '\u0048'));
		this.keyData.add (new KeyData(R.id.key_i, "key_i", "character", '\u0069', '\u0049'));
		this.keyData.add (new KeyData(R.id.key_j, "key_j", "character", '\u006A', '\u004A'));
		this.keyData.add (new KeyData(R.id.key_k, "key_k", "character", '\u006B', '\u004B'));
		this.keyData.add (new KeyData(R.id.key_l, "key_l", "character", '\u006C', '\u004C'));
		this.keyData.add (new KeyData(R.id.key_m, "key_m", "character", '\u006D', '\u004D'));
		this.keyData.add (new KeyData(R.id.key_n, "key_n", "character", '\u006E', '\u004E'));
		this.keyData.add (new KeyData(R.id.key_o, "key_o", "character", '\u006F', '\u004F'));
		this.keyData.add (new KeyData(R.id.key_p, "key_p", "character", '\u0070', '\u0050'));
		this.keyData.add (new KeyData(R.id.key_q, "key_q", "character", '\u0071', '\u0051'));
		this.keyData.add (new KeyData(R.id.key_r, "key_r", "character", '\u0072', '\u0052'));
		this.keyData.add (new KeyData(R.id.key_s, "key_s", "character", '\u0073', '\u0053'));
		this.keyData.add (new KeyData(R.id.key_t, "key_t", "character", '\u0074', '\u0054'));
		this.keyData.add (new KeyData(R.id.key_u, "key_u", "character", '\u0075', '\u0055'));
		this.keyData.add (new KeyData(R.id.key_v, "key_v", "character", '\u0076', '\u0056'));
		this.keyData.add (new KeyData(R.id.key_w, "key_w", "character", '\u0077', '\u0057'));
		this.keyData.add (new KeyData(R.id.key_x, "key_x", "character", '\u0078', '\u0058'));
		this.keyData.add (new KeyData(R.id.key_y, "key_y", "character", '\u0079', '\u0059'));
		this.keyData.add (new KeyData(R.id.key_z, "key_z", "character", '\u007A', '\u005A'));
		this.keyData.add (new KeyData(R.id.key_acute_tilde, "key_acute_tilde", "character", '\u0060', '\u007E'));
		this.keyData.add (new KeyData(R.id.key_one_exclamation, "key_one_exclamation", "character", '\u0031', '\u0021'));
		this.keyData.add (new KeyData(R.id.key_two_ampersat, "key_two_ampersat", "character", '\u0032', '\u0040'));
		this.keyData.add (new KeyData(R.id.key_three_octothrope, "key_three_octothrope", "character", '\u0033', '\u0023'));
		this.keyData.add (new KeyData(R.id.key_four_dollar, "key_four_dollar", "character", '\u0034', '\u0024'));
		this.keyData.add (new KeyData(R.id.key_five_percent, "key_five_percent", "character", '\u0035', '\u0025'));
		this.keyData.add (new KeyData(R.id.key_six_circumflex, "key_six_circumflex", "character", '\u0036', '\u005E'));
		this.keyData.add (new KeyData(R.id.key_seven_ampersand, "key_seven_ampersand", "character", '\u0037', '\u0026'));
		this.keyData.add (new KeyData(R.id.key_eight_asterisk, "key_eight_asterisk", "character", '\u0038', '\u002A'));
		this.keyData.add (new KeyData(R.id.key_nine_open_parenthesis, "key_nine_open_parenthesis", "character", '\u0039', '\u0028'));
		this.keyData.add (new KeyData(R.id.key_zero_close_parenthesis, "key_zero_close_parenthesis", "character", '\u0030', '\u0029'));
		this.keyData.add (new KeyData(R.id.key_hyphen_underscore, "key_hyphen_underscore", "character", '\u002D', '\u005F'));
		this.keyData.add (new KeyData(R.id.key_equal_plus, "key_equal_plus", "character", '\u003D', '\u002B'));
		this.keyData.add (new KeyData(R.id.key_open_bracket_open_brace, "key_open_bracket_open_brace", "character", '\u005B', '\u007B'));
		this.keyData.add (new KeyData(R.id.key_close_bracket_close_brace, "key_close_bracket_close_brace", "character", '\u005D', '\u007D'));
		this.keyData.add (new KeyData(R.id.key_backslash_pipe, "key_backslash_pipe", "character", '\\', '\u007C'));
		this.keyData.add (new KeyData(R.id.key_semicolon_colon, "key_semicolon_colon", "character", '\u003B', '\u003A'));
		this.keyData.add (new KeyData(R.id.key_apostrophe_quotation, "key_apostrophe_quotation", "character", '\'', '\u0022'));
		this.keyData.add (new KeyData(R.id.key_comma_lesser_than, "key_comma_lesser_than", "character", '\u002C', '\u003C'));
		this.keyData.add (new KeyData(R.id.key_period_greater_than, "key_period_greater_than", "character", '\u002E', '\u003E'));
		this.keyData.add (new KeyData(R.id.key_forward_slash_question, "key_forward_slash_question", "character", '\u002F', '\u003F'));
		this.keyData.add (new KeyData(R.id.key_escape, "key_escape", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_backspace, "key_backspace", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_tab, "key_tab", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_capslock, "key_capslock", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_enter, "key_enter", "character", '\n', '\n'));
		this.keyData.add (new KeyData(R.id.key_left_shift, "key_shift", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_right_shift, "key_shift", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_left_control, "key_control", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_spacebar, "key_spacebar", "character", '\u0020', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_search, "key_search", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_menu, "key_menu", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_right_control, "key_control", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_1, "key_function_1", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_2, "key_function_2", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_3, "key_function_3", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_4, "key_function_4", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_5, "key_function_5", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_6, "key_function_6", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_7, "key_function_7", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_8, "key_function_8", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_9, "key_function_9", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_10, "key_function_10", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_11, "key_function_11", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_function_12, "key_function_12", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_empty_0, "key_empty_0", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_left_function, "key_function", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_left_alt, "key_alt", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_right_alt, "key_alt", "control", '\u0000', '\u0000'));
		this.keyData.add (new KeyData(R.id.key_right_function, "key_function", "control", '\u0000', '\u0000'));
	}

	@SuppressLint("ClickableViewAccessibility")
	private void setupListeners() {
		this.key_a.setOnTouchListener (this);
		this.key_b.setOnTouchListener (this);
		this.key_c.setOnTouchListener (this);
		this.key_d.setOnTouchListener (this);
		this.key_e.setOnTouchListener (this);
		this.key_f.setOnTouchListener (this);
		this.key_g.setOnTouchListener (this);
		this.key_h.setOnTouchListener (this);
		this.key_i.setOnTouchListener (this);
		this.key_j.setOnTouchListener (this);
		this.key_k.setOnTouchListener (this);
		this.key_l.setOnTouchListener (this);
		this.key_m.setOnTouchListener (this);
		this.key_n.setOnTouchListener (this);
		this.key_o.setOnTouchListener (this);
		this.key_p.setOnTouchListener (this);
		this.key_q.setOnTouchListener (this);
		this.key_r.setOnTouchListener (this);
		this.key_s.setOnTouchListener (this);
		this.key_t.setOnTouchListener (this);
		this.key_u.setOnTouchListener (this);
		this.key_v.setOnTouchListener (this);
		this.key_w.setOnTouchListener (this);
		this.key_x.setOnTouchListener (this);
		this.key_y.setOnTouchListener (this);
		this.key_z.setOnTouchListener (this);
		this.key_acute_tilde.setOnTouchListener (this);
		this.key_one_exclamation.setOnTouchListener (this);
		this.key_two_ampersat.setOnTouchListener (this);
		this.key_three_octothrope.setOnTouchListener (this);
		this.key_four_dollar.setOnTouchListener (this);
		this.key_five_percent.setOnTouchListener (this);
		this.key_six_circumflex.setOnTouchListener (this);
		this.key_seven_ampersand.setOnTouchListener (this);
		this.key_eight_asterisk.setOnTouchListener (this);
		this.key_nine_open_parenthesis.setOnTouchListener (this);
		this.key_zero_close_parenthesis.setOnTouchListener (this);
		this.key_hyphen_underscore.setOnTouchListener (this);
		this.key_equal_plus.setOnTouchListener (this);
		this.key_open_bracket_open_brace.setOnTouchListener (this);
		this.key_close_bracket_close_brace.setOnTouchListener (this);
		this.key_backslash_pipe.setOnTouchListener (this);
		this.key_semicolon_colon.setOnTouchListener (this);
		this.key_apostrophe_quotation.setOnTouchListener (this);
		this.key_comma_lesser_than.setOnTouchListener (this);
		this.key_period_greater_than.setOnTouchListener (this);
		this.key_forward_slash_question.setOnTouchListener (this);
		this.key_escape.setOnTouchListener (this);
		this.key_backspace.setOnTouchListener (this);
		this.key_tab.setOnTouchListener (this);
		this.key_capslock.setOnTouchListener (this);
		this.key_enter.setOnTouchListener (this);
		this.key_left_shift.setOnTouchListener (this);
		this.key_right_shift.setOnTouchListener (this);
		this.key_left_control.setOnTouchListener (this);
		this.key_spacebar.setOnTouchListener (this);
		this.key_search.setOnTouchListener (this);
		this.key_menu.setOnTouchListener (this);
		this.key_right_control.setOnTouchListener (this);
		this.key_function_1.setOnTouchListener (this);
		this.key_function_2.setOnTouchListener (this);
		this.key_function_3.setOnTouchListener (this);
		this.key_function_4.setOnTouchListener (this);
		this.key_function_5.setOnTouchListener (this);
		this.key_function_6.setOnTouchListener (this);
		this.key_function_7.setOnTouchListener (this);
		this.key_function_8.setOnTouchListener (this);
		this.key_function_9.setOnTouchListener (this);
		this.key_function_10.setOnTouchListener (this);
		this.key_function_11.setOnTouchListener (this);
		this.key_function_12.setOnTouchListener (this);
		this.key_empty_0.setOnTouchListener (this);
		this.key_left_function.setOnTouchListener (this);
		this.key_left_alt.setOnTouchListener (this);
		this.key_right_alt.setOnTouchListener (this);
		this.key_right_function.setOnTouchListener (this);
	}

	@Override
	public boolean onTouch (View v, MotionEvent event) {
		KeyData keyData = this.keyData.get (getKeyIdByViewId (v.getId()));

		if (keyData.type.equals ("control")) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				switch (keyData.code) {
					case "key_shift":
						shiftOn = true;
						Log.d("Event", "Shift-Down");
						break;
					case "key_control":
						controlOn = true;
						Log.d("Event", "Shift-Down");
						break;
					case "key_function":
						functionOn = true;
						Log.d("Event", "Shift-Down");
						break;
				}

				return true;
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				switch (keyData.code) {
					case "key_shift":
						shiftOn = false;
						Log.d("Event", "Shift-Down");
						break;
					case "key_control":
						controlOn = false;
						Log.d("Event", "Shift-Down");
						break;
					case "key_function":
						functionOn = false;
						Log.d("Event", "Shift-Down");
						break;
				}

				return true;
			}
		} else if (keyData.type.equals ("character")) {
			if (shiftOn) {
				characterOn = keyData.secondaryChar;
			} else {
				characterOn = keyData.primaryChar;
			}

			Log.d ("Character", "" + characterOn);
		}

		return false;
	}

	int getKeyIdByViewId (int viewId) {
		int i;

		for (i = 0; i < keyData.size(); i++) {
			if (keyData.get(i).viewId == viewId) {
				break;
			}
		}

		return i;
	}
}