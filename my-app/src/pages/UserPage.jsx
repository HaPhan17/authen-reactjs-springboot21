import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axiosClient from "../api/axiosClient";

function UserPage() {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setLoading(true);

    try {
      const response = await axiosClient.post("/auth/login", { email, password });
      localStorage.setItem("user", JSON.stringify(response.data));
      navigate("/home");
    } catch (err) {
      setError(err.response?.data?.message || "Đăng nhập thất bại. Vui lòng thử lại.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={styles.container}>
      <div style={styles.card}>
        <h1 style={styles.title}>Đăng nhập</h1>
        <form onSubmit={handleSubmit} style={styles.form}>
          {error && (
            <div style={styles.error}>{error}</div>
          )}
          <div style={styles.field}>
            <label style={styles.label}>Email</label>
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="Nhập email"
              style={styles.input}
              required
            />
          </div>
          <div style={styles.field}>
            <label style={styles.label}>Mật khẩu</label>
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Nhập mật khẩu"
              style={styles.input}
              required
            />
          </div>
          <button
            type="submit"
            style={styles.button}
            disabled={loading}
          >
            {loading ? "Đang đăng nhập..." : "Đăng nhập"}
          </button>
        </form>
      </div>
    </div>
  );
}

const styles = {
  container: {
    minHeight: "100vh",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    background: "linear-gradient(135deg, #667eea 0%, #764ba2 100%)",
  },
  card: {
    background: "#fff",
    padding: "40px",
    borderRadius: "12px",
    boxShadow: "0 10px 40px rgba(0,0,0,0.15)",
    width: "100%",
    maxWidth: "400px",
  },
  title: {
    margin: "0 0 24px 0",
    fontSize: "24px",
    fontWeight: 600,
    color: "#1a1a2e",
  },
  form: {
    display: "flex",
    flexDirection: "column",
    gap: "20px",
  },
  field: {
    display: "flex",
    flexDirection: "column",
    gap: "8px",
  },
  label: {
    fontSize: "14px",
    fontWeight: 500,
    color: "#333",
  },
  input: {
    padding: "12px 16px",
    fontSize: "16px",
    border: "1px solid #ddd",
    borderRadius: "8px",
    outline: "none",
  },
  error: {
    padding: "12px",
    background: "#fee",
    color: "#c33",
    borderRadius: "8px",
    fontSize: "14px",
  },
  button: {
    padding: "14px",
    fontSize: "16px",
    fontWeight: 600,
    color: "#fff",
    background: "linear-gradient(135deg, #667eea 0%, #764ba2 100%)",
    border: "none",
    borderRadius: "8px",
    cursor: "pointer",
    marginTop: "8px",
  },
};

export default UserPage;
