import './App.css';
import axios from 'axios';
import Logo from './components/Logo';
import UserInput from './testInput';
import CreateAccountPage from './pages/CreateAccountPage';

function App() {
  // const createAccount = async () => {
  //   console.log("clicked");
  //   console.log("clicked", Date.now())
  //   const payload = {
  //     email: `troy${Date.now()}@example.com`,
  //     accountName: "troy",
  //     prefersDub: true,
  //     prefersSub: true
  //   };

  //   console.log("payload:", payload);

  //   const response = await axios.post("http://localhost:8080/accounts", payload);

  //   try {
  //     const response = await axios.post("http://localhost:8080/accounts", {
  //       email: "troy@example.com",
  //       accountName: "troy",
  //       prefersDub: true,
  //       prefersSub: true
  //     });
  //     console.log("Account created:", response.data);
  //   } catch (error) {
  //     console.error("Error creating account:", error);
  //   }
  // };

  // return (
  //   <div>
  //     <h1>Anizon</h1>
  //     <button onClick={createAccount}>Create Account</button>
  //   </div>
  // );
  
   return (
    <div className="App">
      <CreateAccountPage />
        {/* <Logo />
        <UserInput />
      Get in the Zone....AniZon...e...<br></br>
      <br></br>
      Entities needed: User, Anime, StreamingPlatform (we have a Review Entity, but I will comment this one out for now)<br></br>
      <br></br>
      Each of those entities will have their service and controller that works them and a repo to update (I never made the repos lol I was wondering why mysql had nothing in it.)
      methods needed (just using words and will code them all later) GET a list of anime based on title GET all anime based on streaming platform POST user subscribed platforms, anime they watched i may not worry about the UPDATE and DELETE functions yet<br></br>
      <br></br>
      The feature/user-entity branch is running. Next step is to put this onto the dev branch, then create a new branch. <br></br>
      <br></br>
      The new branch will test our JDBC AND JPA to create an account. */}
    </div> 

  );
}

export default App;
