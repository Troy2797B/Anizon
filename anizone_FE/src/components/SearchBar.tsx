import Button from '@mui/material/Button';
import Input from '@mui/material/Input';
import axios from 'axios';
import { useState } from 'react';

type AnimeSearchResult = {
    id: number;
    title: string;
    synopsis: string;
    imageUrl: string;
};
function SearchBar() {
    const [searchTerm, setSearchTerm] = useState("");
    const handleSearch = async () => {
        // Implement search functionality here
        console.log("Search button clicked");
        // tell animeApiController to make a request to the external API with the search term
        try {
            const response = await axios.get<AnimeSearchResult[]>(`http://localhost:8080/animeApi/search`, { params: { title: searchTerm } });
            console.log(response.data);
        } catch (error) {
            console.error("Error fetching anime data:", error);
        }
    };
    return (
        <div><Input 
                type="text" 
                placeholder="Search..." 
                value={searchTerm}
                onChange={ (e) => setSearchTerm(e.target.value)}
                style={{ flexGrow: 1, margin: "0 10px" }}
            />
            <Button 
                variant="outlined" 
                onClick={handleSearch}>Search
            </Button>
        </div>
    );
}

export default SearchBar;