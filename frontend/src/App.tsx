import DataTable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <h5 className="text-primary">Extrato de transações</h5>
        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
