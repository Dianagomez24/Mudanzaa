package Controller

import Clases.Client
import Utils.Printer

class ClientController(val printer: Printer) : AdminController {

    private val clientList = mutableListOf<Client>()

    override fun registerModel() {
        printer.apply {
            printMsg("Bienvenido, ingrese su nombre(s)")
            val clientNames = readln()
            printMsg("A continuación ingrese su apellido paterno")
            val clientFirstLastName = readln()
            printMsg("Ingrese su  apellido materno")
            val clientSecondLastName = readln()
            printMsg("Por favor, registre su número telefonico ")
            val phoneNumber = readln().toLong()
            printMsg("Por favor, registre su dirección")
            val address = readln()

            val client = Client(
                clientNames,
                clientFirstLastName,
                clientSecondLastName,
                phoneNumber,
                address
            )

            clientList.add(client)
            printMsg("En hora buena. el cliente ha sido registrado exitosamente.")
        }
    }

    override fun showAllModels() {
        if (clientList.isEmpty()) {
            printer.printMsg("Lo sentimos, no se encuentran clientes registrados")
        } else {
            var contador = 1
            for (client in clientList) {
                printer.printMsg("$contador-" + client.getDataClient())
                contador++
            }
        }
    }

    fun getClientAtIndex(index: Int): Client? {
        return clientList.getOrNull(index)
    }

    fun theresNoRegisteredClients(): Boolean {
        return clientList.isEmpty()
    }
}