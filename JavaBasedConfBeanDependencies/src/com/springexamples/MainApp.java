package com.springexamples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(TextEditorConfig.class);

		TextEditor textEditor = (TextEditor) context.getBean(TextEditor.class);
		textEditor.spellCheck();

	}
}
