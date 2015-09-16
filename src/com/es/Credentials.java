package com.es;

import static com.es.util.Utils.*;

public class Credentials {

	private String username;
	private String password;

	/** Serialization lock */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	public Credentials() {
		this("", "");
	}

	public Credentials(String username, String password) {
		this.username = throwIfNull(username);
		this.password = throwIfNull(password);
	}

	/**
	 * Returns the key for these Credentials.
	 * 
	 * @return Credentials key.
	 * @since 1.0.0
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the key for these Credentials.
	 * 
	 * @param key
	 *            Credentials key.
	 * @since 1.0.0
	 */
	public void setUsername(String username) {
		this.username = throwIfNull(username);
	}

	/**
	 * Returns the secret for these Credentials.
	 * 
	 * @return Credentials secret.
	 * @since 1.0.0
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the secret for these Credentials.
	 * 
	 * @param secret
	 *            Credentials secret.
	 * @since 1.0.0
	 */
	public void setPassword(String password) {
		this.password = throwIfNull(password);
	}

	@Override
	public String toString() {
		return String.format("Credentials(username=%s, password=%s)", username, password);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credentials other = (Credentials) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
