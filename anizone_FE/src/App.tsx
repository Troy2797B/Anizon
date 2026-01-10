import React from "react";
import CreateAccountPage from "./pages/CreateAccountPage";
import Logo from "./assets/Logo";
import UserInput from "./testInput";
import HomePage from "./pages/LoggedInHomePage";
import PageHead from "./components/PageHead";
import ProfilePage from "./pages/ProfilePage";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<PageHead />}>
          <Route path="/" element={<HomePage />} />
          <Route path="/create-account" element={<CreateAccountPage />} />
          <Route path="/profile" element={<ProfilePage />} />
          <Route path="/logo" element={<Logo />} />
          <Route path="/user-input" element={<UserInput />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

