import React from "react";

const SearchBar = () => {
  return (
    <div className="flex justify-center my-6">
    <input type="text" placeholder="Ask or Search" className="shadow appearance-none border rounded py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
    <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded ml-2">
      Search
    </button>
  </div>
  );
};

export default SearchBar;