import React from 'react';
import "./index.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Example, Footer, Navbar, News, QuickStats, Reminders, SearchBar } from './components';

const App = () => {
  return (
    <div>
      <Navbar />
      <SearchBar />
      <News />
      <Reminders />
      <QuickStats />
      <Footer />
    </div>
  );
};

export default App;