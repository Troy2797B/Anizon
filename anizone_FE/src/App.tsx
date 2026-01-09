import React from "react";
import CreateAccountPage from "./pages/CreateAccountPage";
import Logo from "./assets/Logo";
import UserInput from "./testInput";
import HomePage from "./pages/HomePage";
import PageHead from "./components/PageHead";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<PageHead />}>
          <Route path="/" element={<HomePage />} />
          <Route path="/create-account" element={<CreateAccountPage />} />
          <Route path="/logo" element={<Logo />} />
          <Route path="/user-input" element={<UserInput />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

