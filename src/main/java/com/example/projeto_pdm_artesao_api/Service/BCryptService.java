package com.example.projeto_pdm_artesao_api.Service;

import org.jspecify.annotations.Nullable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public abstract class BCryptService {
	private static final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();

	public BCryptService() {
	}

	public static @Nullable String encode(@Nullable CharSequence rawPassword) {

		if (rawPassword != null && !rawPassword.isEmpty()) {
			return bCryptEncoder.encode(rawPassword);
		}

		return null;
	}

	public static boolean matches(@Nullable CharSequence rawPassword, @Nullable String hashedPassword) {
		return bCryptEncoder.matches(rawPassword, hashedPassword);
	}
}
