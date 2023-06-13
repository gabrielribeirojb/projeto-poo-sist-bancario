const DataTable = () => {
    return (
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Valor</th>
                        <th>IdTransacao</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>22/04/2023</td>
                        <td>R$200,00</td>
                        <td>3</td>
                    </tr>

                    <tr>
                        <td>22/04/2023</td>
                        <td>-R$200,00</td>
                        <td>2</td>
                    </tr>

                    <tr>
                        <td>22/04/2023</td>
                        <td>R$500,00</td>
                        <td>1</td>
                    </tr>

                </tbody>
            </table>
        </div>
    );
}

export default DataTable;