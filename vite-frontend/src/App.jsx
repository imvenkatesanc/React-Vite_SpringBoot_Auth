import React, { useState } from 'react';
import RegisterPage from './Components/RegisterPage';
import LoginPage from './Components/LoginPage';
import './App.css';

const App = () => {
  const [isRegistered, setIsRegistered] = useState(false);

  return (
    <div className="App">
      {isRegistered ? <LoginPage /> : <RegisterPage />}
      <h4 className="ask">
        {isRegistered ? "If you're not registered!" : "If you're already registered!"}
        <button onClick={() => setIsRegistered(!isRegistered)}>
          {isRegistered ? 'Switch to Register' : 'Switch to Login'}
        </button>
      </h4>
    </div>
  );
};

export default App;
