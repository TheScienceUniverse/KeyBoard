package dev.the01guy.keyboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;

public class KeyboardService extends InputMethodService {
	@Override
	public View onCreateInputView() {
		View keyboardView = getLayoutInflater().inflate (R.layout.keyboard_qwerty, null);
		return keyboardView;
	}
}