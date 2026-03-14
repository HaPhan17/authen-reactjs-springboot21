# My App

React application with login, session storage using localStorage, and page navigation.

## Tech Stack

- **React 19**
- **React Router DOM** – routing
- **Axios** – API calls
- **Create React App** – project scaffolding

## Features

- Login
- Save user data to `localStorage` on successful login
- Redirect to Home page
- Display user info on Home page

## Project Structure

```
src/
├── api/
│   ├── axiosClient.js   # Axios configuration
│   └── userApi.js       # User API
├── pages/
│   ├── UserPage.jsx     # Login page
│   └── HomePage.jsx     # Home page
├── App.js
├── App.css
├── index.js
└── index.css
```

## Installation

### Requirements

- Node.js >= 16.6.0 (v18 or v20 LTS recommended)
- npm or yarn

### Steps

```bash
# Clone repo (if needed)
git clone <repository-url>
cd my-app

# Install dependencies
npm install
```

## Running the App

```bash
# Run in development mode
npm start
```

The app runs at [http://localhost:3000](http://localhost:3000).

## API Configuration

Default API base URL: `http://localhost:8080`. Update `baseURL` in `src/api/axiosClient.js` if your backend uses a different URL.

**Backend must provide:**
- `POST /login` – Login (or `POST /auth/login` depending on baseURL)
  - Body: `{ email, password }`
  - Response: user data (stored in localStorage)

Enable CORS on the backend for `http://localhost:3000`.

## Routes

| Path   | Description  |
|--------|--------------|
| `/`    | Login page   |
| `/home`| Home page    |

## Scripts

| Command          | Description                  |
|------------------|------------------------------|
| `npm start`      | Run dev server               |
| `npm run build`  | Build for production         |
| `npm test`       | Run tests                    |
| `npm run eject`  | Eject CRA (not recommended)  |

## License

Private
