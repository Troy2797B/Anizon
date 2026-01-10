import React from 'react';
import CreateAccountPage from './CreateAccountPage';

function ProfilePage() {
// find a way to get the account info from local storage and display it here
    const account = JSON.parse(localStorage.getItem("createdAccount") || "{}");
    return (
        <div>
            <h1>User Profile</h1>
            <p>Welcome to your profile page!</p>
            <h2>Account Information</h2>
            <pre>{JSON.stringify(account, null, 2)}</pre>
        </div>
    );
}
export default ProfilePage;