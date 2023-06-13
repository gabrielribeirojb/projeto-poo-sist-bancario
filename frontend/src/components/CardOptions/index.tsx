import { Card, Button, Row, Col } from "react-bootstrap";

const CardOptions = () => {
    return (
        <>
        <Row className="default-space">
                <Col sm={4}>
                    <Card style={{ width: '18rem' }}>
                        <Card.Body>
                        <Card.Title>Crie sua conta</Card.Title>
                        <Card.Text>
                            Clique no botão para criar uma conta com os dados que deseja
                            inserir
                        </Card.Text>
                        <Button variant="primary">Criar</Button>
                        </Card.Body>
                    </Card>
                </Col>
                <Col sm={4}>
                    <Card style={{ width: '18rem' }}>
                        <Card.Body>
                        <Card.Title>Faça depósito em uma conta</Card.Title>
                        <Card.Text>
                            Clique no botão para criar realizar um depósito
                        </Card.Text>
                        <Button variant="primary">Depositar</Button>
                        </Card.Body>
                    </Card>
                </Col>
                <Col sm={4}>
                    <Card style={{ width: '18rem' }}>
                        <Card.Body>
                        <Card.Title>Consulte o saldo de uma conta</Card.Title>
                        <Card.Text>
                            Clique no botão consultar o saldo de uma conta
                        </Card.Text>
                        <Button variant="primary">Consultar</Button>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
            <Row className="double-space">
                <Col sm={4}>
                <Card style={{ width: '18rem' }}>
                        <Card.Body>
                        <Card.Title>Realize o saque em uma conta</Card.Title>
                        <Card.Text>
                            Clique no botão para sacar a quantia que deseja em uma conta
                        </Card.Text>
                        <Button variant="primary">Sacar</Button>
                        </Card.Body>
                    </Card>
                </Col>
                <Col sm={4}>
                <Card style={{ width: '18rem' }}>
                        <Card.Body>
                        <Card.Title>Realize o bloqueio de uma conta</Card.Title>
                        <Card.Text>
                            Clique no botão bloquear uma conta
                        </Card.Text>
                        <Button variant="primary">Criar</Button>
                        </Card.Body>
                    </Card>
                </Col>
                <Col sm={4}>
                <Card style={{ width: '18rem' }}>
                        <Card.Body>
                        <Card.Title>Veja o extrato de transações</Card.Title>
                        <Card.Text>
                            Clique no botão para ver o extrato de transações
                        </Card.Text>
                        <Button variant="primary">Criar</Button>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </>
    )
}

export default CardOptions;