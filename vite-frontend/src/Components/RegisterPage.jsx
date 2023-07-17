import React, { useState } from 'react';
import axios from 'axios';
import '../App.css';

const RegisterPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleRegister = async () => {
    try {
      const response = await axios.post('http://localhost:8080/api/v1/register', {
        email,
        password,
      });
      console.log(response.data); // Handle the response from the backend
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="RegisterPage">
      <h1>Register</h1>
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <br />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <br />
      <button onClick={handleRegister}>Register</button>
    </div>
  );
};

export default RegisterPage;
