// import React from 'react';
// import axios from 'axios';
// import { useState, useEffect } from 'react';

// function UserInput() {
//     const [input, setInput] = useState('');

//     // Event is the object representing the event that was triggered. (clicks, key presses, etc.)
//     // In this case, we are using it to get the value of the input field.
//     // target is the property of the event object that refers to the element that triggered the event. this refers to the input element itself.
//     // value is the property of the target that contains the current value of the input field.
//     const handleInputChange = (event: any) => {
//         setInput(event.target.value);
//     }
//     /*{ params: { title: title } } is the configuration object where you specify any query parameters you want to send with your request.
//      Here, title is the query parameter expected by your backend, which you pass the user input to. */
//     const fetchAnimeByTitle = async (title: any) => {
//         try {
//             const response = await axios.get(`http://localhost:8080/anime/search`, { params: { title: title } });
//             console.log(response.data);
//             return response.data;
//         } catch (error) {
//             console.error('Error fetching data: ', error);
//             return null;
//         }
//     };

//     const handleSearch = (event: any) => {
//         event.preventDefault(); // Prevents the default form submission behavior
//         const inputTitle = event.target.elements.searchInput.value;
//     }

//     return (
//         <form onSubmit={handleSearch}>
//             <input name="searchInput" type="text" placeholder="Search for anime..." />
//             <button type="submit">Search</button>
//         </form>
//     )
// }
// export default UserInput;

import React, { useState } from 'react';
import axios from 'axios';

function UserInput() {
    const [input, setInput] = useState('');

    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setInput(event.target.value);
    };

    const fetchAnimeByTitle = async (title: string) => {
        try {
            const response = await axios.get(`http://localhost:8080/anime/search`, { params: { title: title } });
            console.log(response.data);
            return response.data;
        } catch (error) {
            console.error('Error fetching data: ', error);
            return null;
        }
    };

    const handleSearch = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault(); // Prevents the default form submission behavior
        fetchAnimeByTitle(input); // Call the function to fetch anime by title
    };

    return (
        <form onSubmit={handleSearch}>
            <input
                name="searchInput"
                type="text"
                placeholder="Search for anime..."
                value={input}
                onChange={handleInputChange}
            />
            <button type="submit">Search</button>
        </form>
    );
}

export default UserInput;
