package dev.the01guy.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class KeyBoard extends LinearLayout {
	private TextView key_a, key_b, key_c, key_d, key_e, key_f, key_g, key_h, key_i, key_j, key_k, key_l, key_m, key_n, key_o, key_p, key_q, key_r, key_s, key_t, key_u, key_v, key_w, key_x, key_y, key_z;
	private TextView key_function_1, key_function_2, key_function_3, key_function_4, key_function_5, key_function_6, key_function_7, key_function_8, key_function_9, key_function_10, key_function_11, key_function_12;
	private TextView key_empty_0;
	private TextView key_left_function, key_left_alt, key_right_alt, key_right_function;
	private LinearLayout key_one_exclamation, key_two_ampersat, key_three_octothrope, key_four_dollar, key_five_percent, key_six_circumflex, key_seven_ampersand, key_eight_asterisk, key_nine_open_parenthesis, key_zero_close_parenthesis, key_hyphen_underscore, key_equal_plus;
	private LinearLayout key_acute_tilde, key_open_bracket_open_brace, key_close_bracket_close_brace, key_backslash_pipe, key_semicolon_colon, key_apostrophe_quotation, key_comma_lesser_than, key_period_greater_than, key_forward_slash_question;
	private ImageView key_escape, key_backspace, key_tab, key_capslock, key_enter, key_left_shift, key_right_shift, key_left_control, key_spacebar, key_search, key_menu, key_right_control;

	public KeyBoard(Context context) {
		super(context);
		this.setup();
	}

	public KeyBoard(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		this.setup();
	}

	public KeyBoard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.setup();
	}

	private void setup() {
		this.setupElements();
		this.setupListeners();
	}

	private void setupElements() {
		TextView key_a = findViewById (R.id.key_a);
		TextView key_b = findViewById (R.id.key_b);
		TextView key_c = findViewById (R.id.key_c);
		TextView key_d = findViewById (R.id.key_d);
		TextView key_e = findViewById (R.id.key_e);
		TextView key_f = findViewById (R.id.key_f);
		TextView key_g = findViewById (R.id.key_g);
		TextView key_h = findViewById (R.id.key_h);
		TextView key_i = findViewById (R.id.key_i);
		TextView key_j = findViewById (R.id.key_j);
		TextView key_k = findViewById (R.id.key_k);
		TextView key_l = findViewById (R.id.key_l);
		TextView key_m = findViewById (R.id.key_m);
		TextView key_n = findViewById (R.id.key_n);
		TextView key_o = findViewById (R.id.key_o);
		TextView key_p = findViewById (R.id.key_p);
		TextView key_q = findViewById (R.id.key_q);
		TextView key_r = findViewById (R.id.key_r);
		TextView key_s = findViewById (R.id.key_s);
		TextView key_t = findViewById (R.id.key_t);
		TextView key_u = findViewById (R.id.key_u);
		TextView key_v = findViewById (R.id.key_v);
		TextView key_w = findViewById (R.id.key_w);
		TextView key_x = findViewById (R.id.key_x);
		TextView key_y = findViewById (R.id.key_y);
		TextView key_z = findViewById (R.id.key_z);
		TextView key_function_1 = findViewById (R.id.key_function_1);
		TextView key_function_2 = findViewById (R.id.key_function_2);
		TextView key_function_3 = findViewById (R.id.key_function_3);
		TextView key_function_4 = findViewById (R.id.key_function_4);
		TextView key_function_5 = findViewById (R.id.key_function_5);
		TextView key_function_6 = findViewById (R.id.key_function_6);
		TextView key_function_7 = findViewById (R.id.key_function_7);
		TextView key_function_8 = findViewById (R.id.key_function_8);
		TextView key_function_9 = findViewById (R.id.key_function_9);
		TextView key_function_10 = findViewById (R.id.key_function_10);
		TextView key_function_11 = findViewById (R.id.key_function_11);
		TextView key_function_12 = findViewById (R.id.key_function_12);
		TextView key_empty_0 = findViewById (R.id.key_empty_0);
		TextView key_left_function = findViewById (R.id.key_left_function);
		TextView key_left_alt = findViewById (R.id.key_left_alt);
		TextView key_right_alt = findViewById (R.id.key_right_alt);
		TextView key_right_function = findViewById (R.id.key_right_function);
		LinearLayout key_acute_tilde = findViewById (R.id.key_acute_tilde);
		LinearLayout key_one_exclamation = findViewById (R.id.key_one_exclamation);
		LinearLayout key_two_ampersat = findViewById (R.id.key_two_ampersat);
		LinearLayout key_three_octothrope = findViewById (R.id.key_three_octothrope);
		LinearLayout key_four_dollar = findViewById (R.id.key_four_dollar);
		LinearLayout key_five_percent = findViewById (R.id.key_five_percent);
		LinearLayout key_six_circumflex = findViewById (R.id.key_six_circumflex);
		LinearLayout key_seven_ampersand = findViewById (R.id.key_seven_ampersand);
		LinearLayout key_eight_asterisk = findViewById (R.id.key_eight_asterisk);
		LinearLayout key_nine_open_parenthesis = findViewById (R.id.key_nine_open_parenthesis);
		LinearLayout key_zero_close_parenthesis = findViewById (R.id.key_zero_close_parenthesis);
		LinearLayout key_hyphen_underscore = findViewById (R.id.key_hyphen_underscore);
		LinearLayout key_equal_plus = findViewById (R.id.key_equal_plus);
		LinearLayout key_open_bracket_open_brace = findViewById (R.id.key_open_bracket_open_brace);
		LinearLayout key_close_bracket_close_brace = findViewById (R.id.key_close_bracket_close_brace);
		LinearLayout key_backslash_pipe = findViewById (R.id.key_backslash_pipe);
		LinearLayout key_semicolon_colon = findViewById (R.id.key_semicolon_colon);
		LinearLayout key_apostrophe_quotation = findViewById (R.id.key_apostrophe_quotation);
		LinearLayout key_comma_lesser_than = findViewById (R.id.key_comma_lesser_than);
		LinearLayout key_period_greater_than = findViewById (R.id.key_period_greater_than);
		LinearLayout key_forward_slash_question = findViewById (R.id.key_forward_slash_question);
		ImageView key_escape = findViewById (R.id.key_escape);
		ImageView key_backspace = findViewById (R.id.key_backspace);
		ImageView key_tab = findViewById (R.id.key_tab);
		ImageView key_capslock = findViewById (R.id.key_capslock);
		ImageView key_enter = findViewById (R.id.key_enter);
		ImageView key_left_shift = findViewById (R.id.key_left_shift);
		ImageView key_right_shift = findViewById (R.id.key_right_shift);
		ImageView key_left_control = findViewById (R.id.key_left_control);
		ImageView key_spacebar = findViewById (R.id.key_spacebar);
		ImageView key_search = findViewById (R.id.key_search);
		ImageView key_menu = findViewById (R.id.key_menu);
		ImageView key_right_control = findViewById (R.id.key_right_control);
	}

	private void setupListeners() {

	}
}