function HomePage() {
  const user = JSON.parse(localStorage.getItem("user") || "{}");

  return (
    <div style={{ padding: "24px", maxWidth: "800px", margin: "0 auto" }}>
      <h1>Trang chủ</h1>
      {user && Object.keys(user).length > 0 ? (
        <p>Chào mừng, bạn đã đăng nhập thành công!</p>
      ) : (
        <p>Chưa đăng nhập.</p>
      )}
    </div>
  );
}

export default HomePage;
