import Footer from "components/Footer";
import Home from "components/Home";
import NavBar from "components/NavBar";

function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <Home />
      </div>
      <Footer />
    </>
  );
}

export default App;
