import './App.css';
import FeaturedSection from './Components/FeaturedSection';
import Footer from './Components/Footer';
import Header from './Components/Header';
import Sidebar from './Components/Sidebar';

function App() {
  return (
    <div className="App">
     <hr />
     <Header> </Header>
     <hr />
     <Sidebar> </Sidebar>
     <hr />
     <FeaturedSection> </FeaturedSection>
     <hr />
     <Footer> </Footer>
    </div>
  );
}

export default App;
