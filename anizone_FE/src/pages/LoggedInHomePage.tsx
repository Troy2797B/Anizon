import { useEffect, useState } from "react";
import axios from "axios";

// tell program what we can expect from the Account object from the backend
type Account = {
    id: number;
    email: string;
    accountName: string;
    prefersDub: boolean;
    prefersSub: boolean;
};

function HomePage() {
    // state to hold the account information
    const [account, setAccount] = useState<Account | null>(null);
    
    // on component mount, fetch the account info from the backend
    useEffect(() => {
        const id = localStorage.getItem("accountId");
        if (!id) return;

        axios.get<Account>(`http://localhost:8080/accounts/${id}`)
            .then(res => setAccount(res.data))
            .catch(err => console.error("Failed to load account", err));
    }, []);

    return (
        <div>
            <h1>Home</h1>
             {/* display the account information if loaded */}
            {account ? (
                <div>
                    <div>ID: {account.id}</div>
                    <div>Email: {account.email}</div>
                    <div>Name: {account.accountName}</div>
                </div>
            ) : (
                <div>No account loaded</div>
            )}
        </div>
    );
}

export default HomePage;
