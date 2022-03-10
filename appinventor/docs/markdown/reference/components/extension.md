---
layout: documentation
title: Extension
---

[&laquo; Back to index](index.html)
# Extension

Table of Contents:

* [BluetoothLE](#BluetoothLE)
* [Microbit](#Microbit)
* [Microbit_Accelerometer](#Microbit_Accelerometer)
* [Microbit_Button](#Microbit_Button)
* [Microbit_Device_Information](#Microbit_Device_Information)
* [Microbit_Dfu_Control](#Microbit_Dfu_Control)
* [Microbit_Event](#Microbit_Event)
* [Microbit_Generic_Access](#Microbit_Generic_Access)
* [Microbit_Generic_Attribute](#Microbit_Generic_Attribute)
* [Microbit_Io_Pin](#Microbit_Io_Pin)
* [Microbit_Led](#Microbit_Led)
* [Microbit_Magnetometer](#Microbit_Magnetometer)
* [Microbit_Temperature](#Microbit_Temperature)
* [Microbit_Uart](#Microbit_Uart)
* [TextRecognizerGood](#TextRecognizerGood)

## BluetoothLE  {#BluetoothLE}

Bluetooth Low Energy, also referred to as Bluetooth LE or simply BLE, is a new communication protocol similar to classic Bluetooth except that it is designed to consume less power while maintaining comparable functionality. For this reason, Bluetooth LE is the preferred choice of communication with IoT devices that have limited power resources. Starting with Android 4.3, Google introduced built-in support for Bluetooth Low Energy. The BluetoothLE extension requires Android 5.0 or higher to avoid known issues with Google's Bluetooth LE support prior to Android 5.0.



### Properties  {#BluetoothLE-Properties}

{:.properties}

{:id="BluetoothLE.AdvertisementScanPeriod" .number .ro .bo} *AdvertisementScanPeriod*
: Returns the value of ScanPeriod.

{:id="BluetoothLE.AdvertiserAddresses" .list .ro .bo} *AdvertiserAddresses*
: Returns a list of the addresses of devices found during Advertisement scanning.

{:id="BluetoothLE.AdvertiserNames" .list .ro .bo} *AdvertiserNames*
: Returns a list of the names of the devices found during Advertisment scanning.

{:id="BluetoothLE.AutoReconnect" .boolean} *AutoReconnect*
: If true, the application will attempt to reestablish a lost connection to a device due to link loss (e.g., moving out of range). This will not apply to connections that are disconnected by a call to the <a href='#Disconnect'><code>Disconnect</code></a> method. Such disconnects will need to be reconnected via a call to <a href='#Connect'><code>Connect</code></a> or <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a>.

{:id="BluetoothLE.BatteryValue" .text .ro .bo} *BatteryValue*
: Returns the battery level.

{:id="BluetoothLE.ConnectedDeviceName" .text .ro .bo} *ConnectedDeviceName*
: The advertised name of the connected device. If no device is connected or Bluetooth low energy
 is not supported, this will return the empty string.

{:id="BluetoothLE.ConnectedDeviceRssi" .number .ro .bo} *ConnectedDeviceRssi*
: Returns the RSSI (Received Signal Strength Indicator) of connected device.

{:id="BluetoothLE.ConnectionTimeout" .number} *ConnectionTimeout*
: The amount of time, in seconds, that the BluetoothLE component will wait for a connection to be established with a device after a call to <a href='#Connect'><code>Connect</code></a> or <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a>. If a connection is not established in the given amount of time, the attempt will be aborted and the <a href='#ConnectionFailed'><code>ConnectionFailed</code></a> event will be run.

{:id="BluetoothLE.DeviceCharacteristics" .list .ro .bo} *DeviceCharacteristics*
: A list of triples indicating a service UUID, a characteristic UUID, and the characteristic's
 name, if known. The format of the list will be
 ((service1 characteristic1 name1) (service2 characteristic2 name2) ...). If no device is
 connected or Bluetooth low energy is not supported, then an empty list will be returned.

{:id="BluetoothLE.DeviceList" .text .ro .bo} *DeviceList*
: Returns a sorted list of BluetoothLE devices as a String.

{:id="BluetoothLE.DeviceServices" .list .ro .bo} *DeviceServices*
: A list of pairs indicating a service UUID and its name, if known. The format of the list will
 be ((uuid1 name1) (uuid2 name2) ...). If no device is connected or Bluetooth low energy is not
 supported, then an empty list will be returned.

{:id="BluetoothLE.IsDeviceAdvertising" .boolean .ro .bo} *IsDeviceAdvertising*
: Returns true if the device is currently advertising, false otherwise.

{:id="BluetoothLE.IsDeviceConnected" .boolean .ro .bo} *IsDeviceConnected*
: Returns true if a BluetoothLE device is connected; Otherwise, returns false.

{:id="BluetoothLE.Scanning" .boolean .ro .bo} *Scanning*
: The scanning state of the Bluetooth low energy component.

{:id="BluetoothLE.TxPower" .number .ro .bo} *TxPower*
: Returns the transmission power.

### Events  {#BluetoothLE-Events}

{:.events}

{:id="BluetoothLE.BytesReceived"} BytesReceived(*serviceUuid*{:.text},*characteristicUuid*{:.text},*byteValues*{:.list})
: The <code>BytesReceived</code> event is run when one or more byte values are received from a
 connected Bluetooth device. Depending on the <code>sign</code> parameter of the last call to
 <a href="#ReadBytes"><code>ReadBytes</code></a> or
 <a href="#RegisterForBytes"><code>RegisterForBytes</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>byteValues</code> list
 will contain numbers ranging from -128 to 127 (<code>signed = true</code>)
 or 0 to 255 (<code>signed = false</code>).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>byteValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/listsU.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

{:id="BluetoothLE.BytesWritten"} BytesWritten(*serviceUuid*{:.text},*characteristicUuid*{:.text},*byteValues*{:.list})
: The <code>BytesWritten</code> event is run when one or more byte values are written to a
 connected Bluetooth device. <code>byteValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 23 bytes).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>byteValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

{:id="BluetoothLE.Connected"} Connected()
: The <code>Connected</code> event is run after the application successfully connects to a
 Bluetooth low energy device. This can be the result of a call to
 <a href='#Connect'><code>Connect</code></a> or
 <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a>, or as a result of an
 automatic reconnect if the <a href='#AutoReconnect'><code>AutoReconnect</code></a> property
 was true at the time a connection was requested.

{:id="BluetoothLE.ConnectionFailed"} ConnectionFailed(*reason*{:.text})
: The <code>ConnectionFailed</code> event is run when an attempt to connect to a device does not
 succeed. If a reason is provided by the Bluetooth low energy stack it will be reported via the
 <code>reason</code> parameter.

 __Parameters__:

     * <code>reason</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The reason the connection failed, if known.

{:id="BluetoothLE.DeviceFound"} DeviceFound()
: The <code>DeviceFound</code> event is run when a new Bluetooth low energy device is found.

{:id="BluetoothLE.Disconnected"} Disconnected()
: The <code>Disconnected</code> event is run when a Bluetooth low energy device is disconnected.
 This can be caused by a call to <a href="#Disconnect"><code>Disconnect</code></a> or
 <a href="#DisconnectWithAddress"><code>DisconnectWithAddress</code></a>, or after a device
 is moved away or reset such that a loss of connection occurs.

{:id="BluetoothLE.FloatsReceived"} FloatsReceived(*serviceUuid*{:.text},*characteristicUuid*{:.text},*floatValues*{:.list})
: The <code>FloatsReceived</code> event is run when one or more IEEE 754 floating point values are received from a
 connected Bluetooth device. Depending on the <code>shortFloat</code> parameter of the last call to
 <a href="#ReadFloats"><code>ReadFloats</code></a> or
 <a href="#RegisterForFloats"><code>RegisterForFloats</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>floatValues</code> list
 will contain numbers ranging from -65504.0 to 65504.0 (<code>shortFloat = true</code>)
 or -3.402823466E38 to 3.402823466E38 (<code>shortFloat = false</code>).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>floatValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

{:id="BluetoothLE.FloatsWritten"} FloatsWritten(*serviceUuid*{:.text},*characteristicUuid*{:.text},*floatValues*{:.list})
: The <code>FloatsWritten</code> event is run when one or more IEEE 754 floating point values are written to a
 connected Bluetooth device. <code>floatValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 11 short floats or 5 regular floats).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>floatValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

{:id="BluetoothLE.IntegersReceived"} IntegersReceived(*serviceUuid*{:.text},*characteristicUuid*{:.text},*intValues*{:.list})
: The <code>IntegersReceived</code> event is run when one or more 32-bit integer values are received from a
 connected Bluetooth device. Depending on the <code>sign</code> parameter of the last call to
 <a href="#ReadIntegers"><code>ReadIntegers</code></a> or
 <a href="#RegisterForIntegers"><code>RegisterForIntegers</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>intValues</code> list
 will contain numbers ranging from -2147483648 to 2147483647 (<code>signed = true</code>)
 or 0 to 4294967296 (<code>signed = false</code>).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>intValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

{:id="BluetoothLE.IntegersWritten"} IntegersWritten(*serviceUuid*{:.text},*characteristicUuid*{:.text},*intValues*{:.list})
: The <code>IntegersWritten</code> event is run when one or more 32-bit integers values are written to a
 connected Bluetooth device. <code>intValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 5 integers).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>intValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

{:id="BluetoothLE.RssiChanged"} RssiChanged(*rssi*{:.number})
: The <code>RssiChanged</code> event is run when the Received Signal Strength Indicator (RSSI) of
 a discovered Bluetooth low energy device changes.

 __Parameters__:

     * <code>rssi</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The strength of the received signal, in dBm, from -100 to 0.

{:id="BluetoothLE.ShortsReceived"} ShortsReceived(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortValues*{:.list})
: The <code>ShortsReceived</code> event is run when one or more short integer values are received from a
 connected Bluetooth device. Depending on the <code>sign</code> parameter of the last call to
 <a href="#ReadShorts"><code>ReadShorts</code></a> or
 <a href="#RegisterForShorts"><code>RegisterForShorts</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>shortValues</code> list
 will contain numbers ranging from -32768 to 32767 (<code>signed = true</code>)
 or 0 to 65535 (<code>signed = false</code>).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

{:id="BluetoothLE.ShortsWritten"} ShortsWritten(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortValues*{:.list})
: The <code>ShortsWritten</code> event is run when one or more short integers values are written to a
 connected Bluetooth device. <code>shortValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 11 shorts).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

{:id="BluetoothLE.StringsReceived"} StringsReceived(*serviceUuid*{:.text},*characteristicUuid*{:.text},*stringValues*{:.list})
: The <code>StringsReceived</code> event is run when one or more strings are received from a
 connected Bluetooth device. Depending on the <code>utf16</code> parameter of the last call to
 <a href="#ReadStrings"><code>ReadStrings</code></a> or
 <a href="#RegisterForStrings"><code>RegisterForStrings</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>stringValues</code> list
 will contain either a UTF-16 little endian decoded (<code>utf16 = true</code>) or UTF-8
 decoded (<code>utf16 = false</code>) strings. The string length is limited by the maximum
 transmission unit (MTU) of the Bluetooth device, which is typically 23 bytes.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>stringValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The strings will be decoded as UTF-16 or UTF-8 based on the <code>utf16</code> flag previously specified in the call to read or register.

{:id="BluetoothLE.StringsWritten"} StringsWritten(*serviceUuid*{:.text},*characteristicUuid*{:.text},*stringValues*{:.list})
: The <code>StringsWritten</code> event is run when one or more strings are written to a
 connected Bluetooth device. <code>stringValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 22 bytes).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>stringValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

### Methods  {#BluetoothLE-Methods}

{:.methods}

{:id="BluetoothLE.AdvertisementData" class="method returns text"} <i/> AdvertisementData(*deviceAddress*{:.text},*serviceUuid*{:.text})
: Returns the advertisement data associated with the specified device address.

 __Parameters__:

     * <code>deviceAddress</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The Media Access Control (MAC) address of the target Bluetooth low energy device.
     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the advertised service.

{:id="BluetoothLE.AdvertiserAddress" class="method returns text"} <i/> AdvertiserAddress(*deviceName*{:.text})
: Returns the address of the device with the name specified.

 __Parameters__:

     * <code>deviceName</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The advertised name of the target Bluetooth low energy device.

{:id="BluetoothLE.AdvertiserServiceUuids" class="method returns list"} <i/> AdvertiserServiceUuids(*deviceAddress*{:.text})
: Returns the list of services available on the advertising device.

 __Parameters__:

     * <code>deviceAddress</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The Media Access Control (MAC) address of the target Bluetooth low energy device.

{:id="BluetoothLE.CharacteristicByIndex" class="method returns text"} <i/> CharacteristicByIndex(*index*{:.number})
: Returns Unique ID of selected characteristic with index. Index specified by list
 of supported characteristics for a connected device, starting from 1.

 __Parameters__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the desired characteristic, which must be between 1 and the length of the characteristic list.

{:id="BluetoothLE.Connect" class="method"} <i/> Connect(*index*{:.number})
: Use the <code>Connect</code> method to connect to a Bluetooth low energy device at the given
 index in the device list.

 __Parameters__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the target device, which must be between 1 and the length of the list.

{:id="BluetoothLE.ConnectWithAddress" class="method"} <i/> ConnectWithAddress(*address*{:.text})
: Use the <code>ConnectWithAddress</code> method to connect to a specific Bluetooth low energy
 device if its Media Access Control (MAC) address is known. If none of the devices in the device
 list matches the given address, the <a href="#ConnectionFailed"><code>ConnectionFailed</code></a>
 event will be run. Otherwise, if a connection is successful the
 <a href="#Connected"><code>Connected</code></a> event will be run.

 __Parameters__:

     * <code>address</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The MAC address of the target device, of the form "12:34:56:78:90:ab"

{:id="BluetoothLE.Disconnect" class="method"} <i/> Disconnect()
: Disconnects from the currently connected BluetoothLE device if a device is connected.

{:id="BluetoothLE.DisconnectWithAddress" class="method"} <i/> DisconnectWithAddress(*address*{:.text})
: Disconnects from a connected BluetoothLE device with the given address.

 __Parameters__:

     * <code>address</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The Media Access Control (MAC) address of the device to disconnect, of the form "12:34:56:78:90:ab"

{:id="BluetoothLE.FoundDeviceAddress" class="method returns text"} <i/> FoundDeviceAddress(*index*{:.number})
: Gets the Media Access Control (MAC) address of the found device at the given index in the
 device list. Index specifies the position in the BluetoothLE device list, starting from 1.

 __Parameter__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the desired device, which must be between 1 and the length of the device list.

{:id="BluetoothLE.FoundDeviceName" class="method returns text"} <i/> FoundDeviceName(*index*{:.number})
: Gets the name of the found device at the given index in the device list.

 __Parameter__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the desired device, which must be between 1 and the length of the device list.

{:id="BluetoothLE.FoundDeviceRssi" class="method returns number"} <i/> FoundDeviceRssi(*index*{:.number})
: Gets the Received Signal Strength Indicator (RSSI) of the found device at the given index.
 The returned value will be between -100 and 0 indicating the strength of the connection.

 __Parameter__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the desired device, which must be between 1 and the length of the device list.

{:id="BluetoothLE.GetCharacteristicsForService" class="method returns list"} <i/> GetCharacteristicsForService(*serviceUuid*{:.text})
: Returns the list of supported characteristics for the given service. The list will contain
 (UUID, name) pairs for each characteristic provided by the service UUID.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.

{:id="BluetoothLE.ReadBytes" class="method"} <i/> ReadBytes(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Reads one or more 8-bit integer values from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>signed</code> parameter indicates whether
 the bytes should be interpreted as signed values or not when being converted into App Inventor
 numbers. After the bytes are read, the <a href="#BytesReceived"><code>BytesReceived</code></a>
 event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).

{:id="BluetoothLE.ReadFloats" class="method"} <i/> ReadFloats(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortFloat*{:.boolean})
: Reads one or more IEEE 754 floating point numbers from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>shortFloat</code> parameter indicates whether
 the floats are either 16-bit half-precision floating point or 32-bit single precision floating point
 numbers. After the floats are read, the <a href="#FloatsReceived"><code>FloatsReceived</code></a>
 event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortFloat</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).

{:id="BluetoothLE.ReadIntegers" class="method"} <i/> ReadIntegers(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Reads one or more 32-bit integer values from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>signed</code> parameter indicates whether
 the integers should be interpreted as signed values or not when being converted into App Inventor
 numbers. After the integers are read, the
 <a href="#IntegersReceived"><code>IntegersReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).

{:id="BluetoothLE.ReadShorts" class="method"} <i/> ReadShorts(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Reads one or more 16-bit integer values from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>signed</code> parameter indicates whether
 the shorts should be interpreted as signed values or not when being converted into App Inventor
 numbers. After the shorts are read, the <a href="#ShortsReceived"><code>ShortsReceived</code></a>
 event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).

{:id="BluetoothLE.ReadStrings" class="method"} <i/> ReadStrings(*serviceUuid*{:.text},*characteristicUuid*{:.text},*utf16*{:.boolean})
: Reads one or more null-terminated strings from a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The <code>utf16</code> parameter indicates whether
 the content should be decoded as UTF-16 (true) or UTF-8 (false) code points when converting to
 App Inventor strings. After the strings are read, the
 <a href="#StringsReceived"><code>StringsReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>utf16</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the string content as UTF-16 (true) or UTF-8 (false) code points.

{:id="BluetoothLE.RegisterForBytes" class="method"} <i/> RegisterForBytes(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Registers to receive updates when one or more 8-bit integer values from a connected BluetoothLE
 device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>signed</code> parameter indicates whether the bytes should be interpreted as signed
 values or not when being converted into App Inventor numbers. Whenever a change is received,
 the <a href="#BytesReceived"><code>BytesReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).

{:id="BluetoothLE.RegisterForFloats" class="method"} <i/> RegisterForFloats(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortFloat*{:.boolean})
: Registers to receive updates when one or more IEEE 754 floating point numbers from a connected
 BluetoothLE device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>shortFloat</code> parameter indicates whether the floats are either 16-bit half-precision
 floating point or 32-bit single precision floating point numbers. Whenever a change is received,
 the <a href="#FloatsReceived"><code>FloatsReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortFloat</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).

{:id="BluetoothLE.RegisterForIntegers" class="method"} <i/> RegisterForIntegers(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Registers to receive updates when one or more 32-bit integer values from a connected BluetoothLE
 device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>signed</code> parameter indicates whether the integers should be interpreted as signed
 values or not when being converted into App Inventor numbers. Whenever a change is received,
 the <a href="#IntegersReceived"><code>IntegersReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).

{:id="BluetoothLE.RegisterForShorts" class="method"} <i/> RegisterForShorts(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Registers to receive updates when one or more 16-bit integer values from a connected BluetoothLE
 device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>signed</code> parameter indicates whether the shorts should be interpreted as signed
 values or not when being converted into App Inventor numbers. Whenever a change is received,
 the <a href="#ShortsReceived"><code>ShortsReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).

{:id="BluetoothLE.RegisterForStrings" class="method"} <i/> RegisterForStrings(*serviceUuid*{:.text},*characteristicUuid*{:.text},*utf16*{:.boolean})
: Registers to receive updates when one or more null-terminated strings from a connected
 BluetoothLE device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>utf16</code> parameter indicates whether the content should be decoded as UTF-16 (true)
 or UTF-8 (false) code points when converting to App Inventor strings. Whenever a change is
 received, the <a href="#StringsReceived"><code>StringsReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>utf16</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the string content as UTF-16 (true) or UTF-8 (false) code points.

{:id="BluetoothLE.ScanAdvertisements" class="method"} <i/> ScanAdvertisements(*scanPeriod*{:.number})
: Scans for advertising Bluetooth low energy devices.

 __Parameter__:

     * <code>scanPeriod</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The amount of time to spend scanning, in milliseconds.

{:id="BluetoothLE.ServiceByIndex" class="method returns text"} <i/> ServiceByIndex(*index*{:.number})
: Returns the Unique ID of the service at the given index in the service list.

 __Parameters__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the desired service, which must be between 1 and the length of the service list.

{:id="BluetoothLE.StartAdvertising" class="method"} <i/> StartAdvertising(*inData*{:.text},*serviceUuid*{:.text})
: Creates and publishes a Bluetooth low energy advertisement.

 __Parameters__:

     * <code>inData</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The data to be included in the service advertisement.
     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.

{:id="BluetoothLE.StartScanning" class="method"} <i/> StartScanning()
: Starts scanning for Bluetooth low energy devices.

{:id="BluetoothLE.StopAdvertising" class="method"} <i/> StopAdvertising()
: Stops Bluetooth low energy advertisement from a previous call to
 <a href="#StartAdvertising"><code>StartAdvertising</code></a>.

{:id="BluetoothLE.StopScanning" class="method"} <i/> StopScanning()
: Stops scanning for Bluetooth low energy devices.

{:id="BluetoothLE.StopScanningAdvertisements" class="method"} <i/> StopScanningAdvertisements()
: Stops scanning for Bluetooth low energy advertisements.

{:id="BluetoothLE.SupportedCharacteristics" class="method returns text"} <i/> SupportedCharacteristics()
: Returns a list of supported characteristic for the connected device as a string.

{:id="BluetoothLE.SupportedServices" class="method returns text"} <i/> SupportedServices()
: Returns the list of supported service for the connected device as a string.

{:id="BluetoothLE.UnregisterForValues" class="method"} <i/> UnregisterForValues(*service_uuid*{:.text},*characteristic_uuid*{:.text})
: Unregisters for updates from the given service and characteristic.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.

{:id="BluetoothLE.WriteBytes" class="method"} <i/> WriteBytes(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 8-bit integer values to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>signed</code> is true, the acceptable values are
 between -128 and 127. If <code>signed</code> is false, the acceptable values are
 between 0 and 255.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteBytesWithResponse" class="method"} <i/> WriteBytesWithResponse(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 8-bit integer values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#BytesWritten"><code>BytesWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>signed</code> is true, the acceptable
 values are between -128 and 127. If <code>signed</code> is false, the acceptable values are
 between 0 and 255.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteFloats" class="method"} <i/> WriteFloats(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortFloat*{:.boolean},*values*{:.any})
: Writes one or more IEEE 754 floating point numbers to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>shortFloat</code> is true, then each numeric value will be
 compressed to fit into a 16-bit half-precision floating point value. If <code>shortFloat</code>
 is false, then each numeric value will be sent as a 32-bit single precision floating point value.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortFloat</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteFloatsWithResponse" class="method"} <i/> WriteFloatsWithResponse(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortFloat*{:.boolean},*values*{:.any})
: Writes one or more IEEE 754 floating point values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#FloatsWritten"><code>FloatsWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>shortFloat</code> is false,
 then each numeric value will be sent as a 32-bit single precision floating point value.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortFloat</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteIntegers" class="method"} <i/> WriteIntegers(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 32-bit integer values to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>signed</code> is true, the acceptable values are
 between -2147483648 and 2147483647. If <code>signed</code> is false, the acceptable values are
 between 0 and 4294967295.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteIntegersWithResponse" class="method"} <i/> WriteIntegersWithResponse(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 32-bit integer values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#IntegersWritten"><code>IntegersWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>signed</code> is true, the acceptable
 values are between -2147483648 and 2147483647. If <code>signed</code> is false, the acceptable
 values are between 0 and 4294967295.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteShorts" class="method"} <i/> WriteShorts(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 16-bit integer values to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>signed</code> is true, the acceptable values are
 between -32768 and 32767. If <code>signed</code> is false, the acceptable values are
 between 0 and 65535.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteShortsWithResponse" class="method"} <i/> WriteShortsWithResponse(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 16-bit integer values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#ShortsWritten"><code>ShortsWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>signed</code> is true, the acceptable
 values are between -32768 and 32767. If <code>signed</code> is false, the acceptable values
 are between 0 and 65535.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteStrings" class="method"} <i/> WriteStrings(*serviceUuid*{:.text},*characteristicUuid*{:.text},*utf16*{:.boolean},*values*{:.any})
: Writes one or more strings to a connected BluetoothLE device. Service Unique ID and
 Characteristic Unique ID are required. The values parameter can either be a single string or a
 list of strings. If <code>utf16</code> is true, the string(s) will be sent using UTF-16 little
 endian encoding. If <code>utf16</code> is false, the string(s) will be sent using UTF-8
 encoding.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>utf16</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Send the string encoded as UTF-16 little endian (true) or UTF-8 (false) code points.
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteStringsWithResponse" class="method"} <i/> WriteStringsWithResponse(*serviceUuid*{:.text},*characteristicUuid*{:.text},*utf16*{:.boolean},*values*{:.any})
: Writes one or more strings to a connected BluetoothLE device and waits for an acknowledgement
 via the <a href="#StringsWritten"><code>StringsWritten</code></a> event. Service Unique ID and
 Characteristic Unique ID are required. The values parameter can either be a single string or a
 list of values. If <code>utf16</code> is true, the string(s) will be sent using UTF-16 little
 endian encoding. If <code>utf16</code> is false, the string(s) will be sent using UTF-8
 encoding.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>utf16</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Send the string encoded as UTF-16 little endian (true) or UTF-8 (false) code points.
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

## Microbit  {#Microbit}

Component for Microbit



### Properties  {#Microbit-Properties}

{:.properties}

{:id="Microbit.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device.

### Events  {#Microbit-Events}

{:.events}

{:id="Microbit.AccelerometerDataReceived"} AccelerometerDataReceived(*Accelerometer_X_*{:.number},*Accelerometer_Y*{:.number},*Accelerometer_Z*{:.number})
: Event for AccelerometerDataReceived

{:id="Microbit.AccelerometerPeriodReceived"} AccelerometerPeriodReceived(*Accelerometer_Period*{:.number})
: Event for AccelerometerPeriodReceived

{:id="Microbit.AppearanceReceived"} AppearanceReceived(*Category*{:.number})
: Event for AppearanceReceived

{:id="Microbit.ButtonAStateReceived"} ButtonAStateReceived(*Button_State_Value*{:.number})
: Event for ButtonAStateReceived

{:id="Microbit.ButtonBStateReceived"} ButtonBStateReceived(*Button_State_Value*{:.number})
: Event for ButtonBStateReceived

{:id="Microbit.DFUControlReceived"} DFUControlReceived(*dfu_control*{:.number})
: Event for DFUControlReceived

{:id="Microbit.DeviceNameReceived"} DeviceNameReceived(*Name*{:.text})
: Event for DeviceNameReceived

{:id="Microbit.FirmwareRevisionStringReceived"} FirmwareRevisionStringReceived(*Firmware_Revision*{:.text})
: Event for FirmwareRevisionStringReceived

{:id="Microbit.HardwareRevisionStringReceived"} HardwareRevisionStringReceived(*Hardware_Revision*{:.text})
: Event for HardwareRevisionStringReceived

{:id="Microbit.LEDMatrixStateReceived"} LEDMatrixStateReceived(*LED_Matrix_State*{:.list})
: Event for LEDMatrixStateReceived

{:id="Microbit.MagnetometerBearingReceived"} MagnetometerBearingReceived(*bearing_value*{:.number})
: Event for MagnetometerBearingReceived

{:id="Microbit.MagnetometerDataReceived"} MagnetometerDataReceived(*Magnetometer_X*{:.number},*Magnetometer_Y*{:.number},*Magnetometer_Z*{:.number})
: Event for MagnetometerDataReceived

{:id="Microbit.MagnetometerPeriodReceived"} MagnetometerPeriodReceived(*Magnetometer_Period*{:.number})
: Event for MagnetometerPeriodReceived

{:id="Microbit.ManufacturerNameStringReceived"} ManufacturerNameStringReceived(*Manufacturer_Name*{:.text})
: Event for ManufacturerNameStringReceived

{:id="Microbit.MicroBitEventReceived"} MicroBitEventReceived(*Event_Type_And_Value*{:.number})
: Event for MicroBitEventReceived

{:id="Microbit.MicroBitRequirementsReceived"} MicroBitRequirementsReceived(*microbit_reqs_value*{:.number})
: Event for MicroBitRequirementsReceived

{:id="Microbit.ModelNumberStringReceived"} ModelNumberStringReceived(*Model_Number*{:.text})
: Event for ModelNumberStringReceived

{:id="Microbit.PeripheralPreferredConnectionParametersReceived"} PeripheralPreferredConnectionParametersReceived(*Minimum_Connection_Interval*{:.number},*Maximum_Connection_Interval*{:.number},*Slave_Latency*{:.number},*Connection_Supervision_Timeout_Multiplier*{:.number})
: Event for PeripheralPreferredConnectionParametersReceived

{:id="Microbit.PinADConfigurationReceived"} PinADConfigurationReceived(*Pin_AD_Config_Value*{:.list})
: Event for PinADConfigurationReceived

{:id="Microbit.PinDataReceived"} PinDataReceived(*IO_Pin_Data*{:.list})
: Event for PinDataReceived

{:id="Microbit.PinIOConfigurationReceived"} PinIOConfigurationReceived(*Pin_IO_Config_Value*{:.list})
: Event for PinIOConfigurationReceived

{:id="Microbit.ScrollingDelayReceived"} ScrollingDelayReceived(*Scrolling_Delay_Value*{:.number})
: Event for ScrollingDelayReceived

{:id="Microbit.SerialNumberStringReceived"} SerialNumberStringReceived(*Serial_Number*{:.text})
: Event for SerialNumberStringReceived

{:id="Microbit.TXCharacteristicReceived"} TXCharacteristicReceived(*UART_TX_Field*{:.list})
: Event for TXCharacteristicReceived

{:id="Microbit.TemperaturePeriodReceived"} TemperaturePeriodReceived(*temperature_period_value*{:.number})
: Event for TemperaturePeriodReceived

{:id="Microbit.TemperatureReceived"} TemperatureReceived(*temperature_value*{:.number})
: Event for TemperatureReceived

{:id="Microbit.WroteAccelerometerPeriod"} WroteAccelerometerPeriod(*Accelerometer_Period*{:.number})
: Event for WroteAccelerometerPeriod

{:id="Microbit.WroteClientEvent"} WroteClientEvent(*Event_Types_And_Values*{:.number})
: Event for WroteClientEvent

{:id="Microbit.WroteClientRequirements"} WroteClientRequirements(*Client_Requirements_Value*{:.number})
: Event for WroteClientRequirements

{:id="Microbit.WroteDFUControl"} WroteDFUControl(*dfu_control*{:.number})
: Event for WroteDFUControl

{:id="Microbit.WroteDeviceName"} WroteDeviceName(*Name*{:.text})
: Event for WroteDeviceName

{:id="Microbit.WroteLEDMatrixState"} WroteLEDMatrixState(*LED_Matrix_State*{:.list})
: Event for WroteLEDMatrixState

{:id="Microbit.WroteLEDText"} WroteLEDText(*LED_Text_Value*{:.text})
: Event for WroteLEDText

{:id="Microbit.WroteMagnetometerPeriod"} WroteMagnetometerPeriod(*Magnetometer_Period*{:.number})
: Event for WroteMagnetometerPeriod

{:id="Microbit.WrotePWMControl"} WrotePWMControl(*PWM_Control_Field*{:.list})
: Event for WrotePWMControl

{:id="Microbit.WrotePinADConfiguration"} WrotePinADConfiguration(*Pin_AD_Config_Value*{:.list})
: Event for WrotePinADConfiguration

{:id="Microbit.WrotePinData"} WrotePinData(*IO_Pin_Data*{:.list})
: Event for WrotePinData

{:id="Microbit.WrotePinIOConfiguration"} WrotePinIOConfiguration(*Pin_IO_Config_Value*{:.list})
: Event for WrotePinIOConfiguration

{:id="Microbit.WroteRXCharacteristic"} WroteRXCharacteristic(*UART_TX_Field*{:.list})
: Event for WroteRXCharacteristic

{:id="Microbit.WroteScrollingDelay"} WroteScrollingDelay(*Scrolling_Delay_Value*{:.number})
: Event for WroteScrollingDelay

{:id="Microbit.WroteTemperaturePeriod"} WroteTemperaturePeriod(*temperature_period_value*{:.number})
: Event for WroteTemperaturePeriod

### Methods  {#Microbit-Methods}

{:.methods}

{:id="Microbit.ReadAccelerometerData" class="method"} <i/> ReadAccelerometerData()
: Method for ReadAccelerometerData

{:id="Microbit.ReadAccelerometerPeriod" class="method"} <i/> ReadAccelerometerPeriod()
: Method for ReadAccelerometerPeriod

{:id="Microbit.ReadAppearance" class="method"} <i/> ReadAppearance()
: Method for ReadAppearance

{:id="Microbit.ReadButtonAState" class="method"} <i/> ReadButtonAState()
: Method for ReadButtonAState

{:id="Microbit.ReadButtonBState" class="method"} <i/> ReadButtonBState()
: Method for ReadButtonBState

{:id="Microbit.ReadDFUControl" class="method"} <i/> ReadDFUControl()
: Method for ReadDFUControl

{:id="Microbit.ReadDeviceName" class="method"} <i/> ReadDeviceName()
: Method for ReadDeviceName

{:id="Microbit.ReadFirmwareRevisionString" class="method"} <i/> ReadFirmwareRevisionString()
: Method for ReadFirmwareRevisionString

{:id="Microbit.ReadHardwareRevisionString" class="method"} <i/> ReadHardwareRevisionString()
: Method for ReadHardwareRevisionString

{:id="Microbit.ReadLEDMatrixState" class="method"} <i/> ReadLEDMatrixState()
: Method for ReadLEDMatrixState

{:id="Microbit.ReadMagnetometerBearing" class="method"} <i/> ReadMagnetometerBearing()
: Method for ReadMagnetometerBearing

{:id="Microbit.ReadMagnetometerData" class="method"} <i/> ReadMagnetometerData()
: Method for ReadMagnetometerData

{:id="Microbit.ReadMagnetometerPeriod" class="method"} <i/> ReadMagnetometerPeriod()
: Method for ReadMagnetometerPeriod

{:id="Microbit.ReadManufacturerNameString" class="method"} <i/> ReadManufacturerNameString()
: Method for ReadManufacturerNameString

{:id="Microbit.ReadMicroBitEvent" class="method"} <i/> ReadMicroBitEvent()
: Method for ReadMicroBitEvent

{:id="Microbit.ReadMicroBitRequirements" class="method"} <i/> ReadMicroBitRequirements()
: Method for ReadMicroBitRequirements

{:id="Microbit.ReadModelNumberString" class="method"} <i/> ReadModelNumberString()
: Method for ReadModelNumberString

{:id="Microbit.ReadPeripheralPreferredConnectionParameters" class="method"} <i/> ReadPeripheralPreferredConnectionParameters()
: Method for ReadPeripheralPreferredConnectionParameters

{:id="Microbit.ReadPinADConfiguration" class="method"} <i/> ReadPinADConfiguration()
: Method for ReadPinADConfiguration

{:id="Microbit.ReadPinData" class="method"} <i/> ReadPinData()
: Method for ReadPinData

{:id="Microbit.ReadPinIOConfiguration" class="method"} <i/> ReadPinIOConfiguration()
: Method for ReadPinIOConfiguration

{:id="Microbit.ReadScrollingDelay" class="method"} <i/> ReadScrollingDelay()
: Method for ReadScrollingDelay

{:id="Microbit.ReadSerialNumberString" class="method"} <i/> ReadSerialNumberString()
: Method for ReadSerialNumberString

{:id="Microbit.ReadTemperature" class="method"} <i/> ReadTemperature()
: Method for ReadTemperature

{:id="Microbit.ReadTemperaturePeriod" class="method"} <i/> ReadTemperaturePeriod()
: Method for ReadTemperaturePeriod

{:id="Microbit.RequestAccelerometerDataUpdates" class="method"} <i/> RequestAccelerometerDataUpdates()
: Method for RequestAccelerometerDataUpdates

{:id="Microbit.RequestButtonAStateUpdates" class="method"} <i/> RequestButtonAStateUpdates()
: Method for RequestButtonAStateUpdates

{:id="Microbit.RequestButtonBStateUpdates" class="method"} <i/> RequestButtonBStateUpdates()
: Method for RequestButtonBStateUpdates

{:id="Microbit.RequestMagnetometerBearingUpdates" class="method"} <i/> RequestMagnetometerBearingUpdates()
: Method for RequestMagnetometerBearingUpdates

{:id="Microbit.RequestMagnetometerDataUpdates" class="method"} <i/> RequestMagnetometerDataUpdates()
: Method for RequestMagnetometerDataUpdates

{:id="Microbit.RequestMicroBitEventUpdates" class="method"} <i/> RequestMicroBitEventUpdates()
: Method for RequestMicroBitEventUpdates

{:id="Microbit.RequestMicroBitRequirementsUpdates" class="method"} <i/> RequestMicroBitRequirementsUpdates()
: Method for RequestMicroBitRequirementsUpdates

{:id="Microbit.RequestPinDataUpdates" class="method"} <i/> RequestPinDataUpdates()
: Method for RequestPinDataUpdates

{:id="Microbit.RequestTXCharacteristic" class="method"} <i/> RequestTXCharacteristic()
: Method for RequestTXCharacteristic

{:id="Microbit.RequestTemperatureUpdates" class="method"} <i/> RequestTemperatureUpdates()
: Method for RequestTemperatureUpdates

{:id="Microbit.StopAccelerometerDataUpdates" class="method"} <i/> StopAccelerometerDataUpdates()
: Method for StopAccelerometerDataUpdates

{:id="Microbit.StopButtonAStateUpdates" class="method"} <i/> StopButtonAStateUpdates()
: Method for StopButtonAStateUpdates

{:id="Microbit.StopButtonBStateUpdates" class="method"} <i/> StopButtonBStateUpdates()
: Method for StopButtonBStateUpdates

{:id="Microbit.StopMagnetometerBearingUpdates" class="method"} <i/> StopMagnetometerBearingUpdates()
: Method for StopMagnetometerBearingUpdates

{:id="Microbit.StopMagnetometerDataUpdates" class="method"} <i/> StopMagnetometerDataUpdates()
: Method for StopMagnetometerDataUpdates

{:id="Microbit.StopMicroBitEventUpdates" class="method"} <i/> StopMicroBitEventUpdates()
: Method for StopMicroBitEventUpdates

{:id="Microbit.StopMicroBitRequirementsUpdates" class="method"} <i/> StopMicroBitRequirementsUpdates()
: Method for StopMicroBitRequirementsUpdates

{:id="Microbit.StopPinDataUpdates" class="method"} <i/> StopPinDataUpdates()
: Method for StopPinDataUpdates

{:id="Microbit.StopTXCharacteristicUpdates" class="method"} <i/> StopTXCharacteristicUpdates()
: Method for StopTXCharacteristicUpdates

{:id="Microbit.StopTemperatureUpdates" class="method"} <i/> StopTemperatureUpdates()
: Method for StopTemperatureUpdates

{:id="Microbit.WriteAccelerometerPeriod" class="method"} <i/> WriteAccelerometerPeriod(*value*{:.number})
: Method for WriteAccelerometerPeriod

{:id="Microbit.WriteClientEvent" class="method"} <i/> WriteClientEvent(*Event_Types_And_Values*{:.any})
: Method for WriteClientEvent

{:id="Microbit.WriteClientRequirements" class="method"} <i/> WriteClientRequirements(*client_requirements_value*{:.any})
: Method for WriteClientRequirements

{:id="Microbit.WriteDFUControl" class="method"} <i/> WriteDFUControl(*dfu_control*{:.number})
: Method for WriteDFUControl

{:id="Microbit.WriteDeviceName" class="method"} <i/> WriteDeviceName(*name*{:.text})
: Method for WriteDeviceName

{:id="Microbit.WriteLEDMatrixState" class="method"} <i/> WriteLEDMatrixState(*LED_Matrix_State*{:.any})
: Method for WriteLEDMatrixState

{:id="Microbit.WriteLEDText" class="method"} <i/> WriteLEDText(*LED_Text_Value*{:.text})
: Method for WriteLEDText

{:id="Microbit.WriteMagnetometerPeriod" class="method"} <i/> WriteMagnetometerPeriod(*Magnetometer_Period*{:.number})
: Method for WriteMagnetometerPeriod

{:id="Microbit.WritePWMControl" class="method"} <i/> WritePWMControl(*PWM_Control_Field*{:.any})
: Method for WritePWMControl

{:id="Microbit.WritePinADConfiguration" class="method"} <i/> WritePinADConfiguration(*Pin_AD_Config_Value*{:.any})
: Method for WritePinADConfiguration

{:id="Microbit.WritePinData" class="method"} <i/> WritePinData(*IO_Pin_Data*{:.any})
: Method for WritePinData

{:id="Microbit.WritePinIOConfiguration" class="method"} <i/> WritePinIOConfiguration(*Pin_IO_Config_Value*{:.any})
: Method for WritePinIOConfiguration

{:id="Microbit.WriteRXCharacteristic" class="method"} <i/> WriteRXCharacteristic(*UART_TX*{:.any})
: Method for WriteRXCharacteristic

{:id="Microbit.WriteScrollingDelay" class="method"} <i/> WriteScrollingDelay(*Scrolling_Delay_Value*{:.number})
: Method for WriteScrollingDelay

{:id="Microbit.WriteTemperaturePeriod" class="method"} <i/> WriteTemperaturePeriod(*value*{:.number})
: Method for WriteTemperaturePeriod

## Microbit_Accelerometer  {#Microbit_Accelerometer}

Component for Microbit_Accelerometer



### Properties  {#Microbit_Accelerometer-Properties}

{:.properties}

{:id="Microbit_Accelerometer.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Accelerometer-Events}

{:.events}

{:id="Microbit_Accelerometer.AccelerometerDataReceived"} AccelerometerDataReceived(*Accelerometer_X*{:.number},*Accelerometer_Y*{:.number},*Accelerometer_Z*{:.number})
: The <code>AccelerometerDataReceived</code> event is run whenever accelerometer samples are
 received from the micro:bit. This is usually a result of performing a
 <a href="#ReadAccelerometerData">read</a> or
 <a href="#RequestAccelerometerDataUpdates">request</a> operation.
 The X, Y, and Z values are in thousands of 1 Earth gravity (G=-9.8 m/s<sup>2</sup>), and so
 should be scaled by 1/1000.

 __Parameters__:

    + <code>Accelerometer_X</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The X value of the accelerometer, in milliG.
    + <code>Accelerometer_Y</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Y value of the accelerometer, in milliG.
    + <code>Accelerometer_Z</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Z value of the accelerometer, in milliG.

{:id="Microbit_Accelerometer.AccelerometerPeriodReceived"} AccelerometerPeriodReceived(*Accelerometer_Period*{:.number})
: The <code>AccelerometerPeriodReceived</code> event is run after the micro:bit's accelerometer
 period is read from the device.

 __Parameters__:

    + <code>Accelerometer_Period</code> (_number_) &mdash; The current reporting interval for the micro:bit's accelerometer, in milliseconds.

{:id="Microbit_Accelerometer.WroteAccelerometerPeriod"} WroteAccelerometerPeriod(*Accelerometer_Period*{:.number})
: The <code>WroteAccelerometerPeriod</code> event is run after the micro:bit reports its period
 as requested by an earlier call to the
 <a href="#ReadAccelerometerPeriod"><code>ReadAccelerometerPeriod</code></a> method.

 __Parameters__:

    + <code>Accelerometer_Period</code> (_number_) &mdash; The reporting period for the micro:bit's accelerometer, in milliseconds.

### Methods  {#Microbit_Accelerometer-Methods}

{:.methods}

{:id="Microbit_Accelerometer.ReadAccelerometerData" class="method"} <i/> ReadAccelerometerData()
: Read a single sample of accelerometer data from the micro:bit. On successful read, the
 <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a>
 event will be run.

{:id="Microbit_Accelerometer.ReadAccelerometerPeriod" class="method"} <i/> ReadAccelerometerPeriod()
: Read the current report rate for the micro:bit accelerometer. After the period is read, it will
 be received by the
 <a href="#AccelerometerPeriodReceived"><code>AccelerometerPeriodReceived</code></a> event.

{:id="Microbit_Accelerometer.RequestAccelerometerDataUpdates" class="method"} <i/> RequestAccelerometerDataUpdates()
: Request notifications of changes in the micro:bit's accelerometer. Changes in the accelerometer
 will be reported at a rate determined by the last period value set by a call to
 <a href="#WriteAccelerometerPeriod"><code>WriteAccelerometerPeriod</code></a>. Accelerometer
 data will be reported through the
 <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a> event.

{:id="Microbit_Accelerometer.StopAccelerometerDataUpdates" class="method"} <i/> StopAccelerometerDataUpdates()
: Stop receiving updates from the micro:bit's accelerometer. Note that there may be pending
 messages from the device that will still be reported through the
 <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a> event.

{:id="Microbit_Accelerometer.WriteAccelerometerPeriod" class="method"} <i/> WriteAccelerometerPeriod(*period*{:.number})
: Use the <code>WriteAccelerometerPeriod</code> method to change how frequently the micro:bit
 sends accelerometer data to App Inventor. The period is measured in milliseconds. According to
 the micro:bit specification, valid values are 1, 2, 5, 10, 20, 80, 160, and 640 milliseconds.

 __Parameters__:

    + <code>period</code> (_number_) &mdash; The new accelerometer reporting period, in milliseconds.

## Microbit_Button  {#Microbit_Button}

Component for Microbit_Button



### Properties  {#Microbit_Button-Properties}

{:.properties}

{:id="Microbit_Button.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Button-Events}

{:.events}

{:id="Microbit_Button.ButtonAStateReceived"} ButtonAStateReceived(*Button_State_Value*{:.number})
: After performing a <a href="#ReadButtonAState">read</a> or
 <a href="#RequestButtonAStateUpdates">request for updates</a>, the
 <code>ButtonAStateReceived</code> event will be run with information about the button state.

 __Parameters__:

   + <code>Button_State_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The state of the micro:bit's A button; 0 for released, 1 for pressed, 2 for long-pressed.

{:id="Microbit_Button.ButtonBStateReceived"} ButtonBStateReceived(*Button_State_Value*{:.number})
: After performing a <a href="#ReadButtonBState">read</a> or
 <a href="#RequestButtonBStateUpdates">request for updates</a>, the
 <code>ButtonBStateReceived</code> event will be run with information about the button state.

 __Parameters__:

   + <code>Button_State_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The state of the micro:bit's B button; 0 for released, 1 for pressed, 2 for long-pressed.

### Methods  {#Microbit_Button-Methods}

{:.methods}

{:id="Microbit_Button.ReadButtonAState" class="method"} <i/> ReadButtonAState()
: Read the current state of the micro:bit's A button. After a successful read, the
 <a href="#ButtonAStateReceived"><code>ButtonAStateReceived</code></a> event will be run.

{:id="Microbit_Button.ReadButtonBState" class="method"} <i/> ReadButtonBState()
: Read the current state of the micro:bit's B button. After a successful read, the
 <a href="#ButtonBStateReceived"><code>ButtonBStateReceived</code></a> event will be run.

{:id="Microbit_Button.RequestButtonAStateUpdates" class="method"} <i/> RequestButtonAStateUpdates()
: Request updates to the state of the micro:bit's A button. After requesting updates, the
 <a href="#ButtonAStateReceived"><code>ButtonAStateReceived</code></a> will be run whenever
 the micro:bit reports a button state change to the app. Pressing and holding the button
 will result in a second event with the value 2 to indicate a long press.

{:id="Microbit_Button.RequestButtonBStateUpdates" class="method"} <i/> RequestButtonBStateUpdates()
: Request updates to the state of the micro:bit's B button. After requesting updates, the
 <a href="#ButtonBStateReceived"><code>ButtonBStateReceived</code></a> will be run whenever
 the micro:bit reports a button state change to the app. Pressing and holding the button will
 result in a second event with the value 2 to indicate a long press.

{:id="Microbit_Button.StopButtonAStateUpdates" class="method"} <i/> StopButtonAStateUpdates()
: Stop receiving updates about the state of the micro:bit's A button. Note that there may
 be pending updates that have not been processed that will result in
 <a href="#ButtonAStateReceived"><code>ButtonAStateReceived</code></a>

{:id="Microbit_Button.StopButtonBStateUpdates" class="method"} <i/> StopButtonBStateUpdates()
: Stop receiving updates about the state of the micro:bit's B button. Note that there may be
 pending updates that have not been processed that will result in
 <a href="#ButtonBStateReceived"><code>ButtonBStateReceived</code></a>.

## Microbit_Device_Information  {#Microbit_Device_Information}

Component for Microbit_Device_Information



### Properties  {#Microbit_Device_Information-Properties}

{:.properties}

{:id="Microbit_Device_Information.BluetoothDevice" .component} *BluetoothDevice*
: Property for BluetoothDevice

### Events  {#Microbit_Device_Information-Events}

{:.events}

{:id="Microbit_Device_Information.FirmwareRevisionStringReceived"} FirmwareRevisionStringReceived(*Firmware_Revision_String*{:.text})
: Event for FirmwareRevisionStringReceived

{:id="Microbit_Device_Information.HardwareRevisionStringReceived"} HardwareRevisionStringReceived(*Hardware_Revision_String*{:.text})
: Event for HardwareRevisionStringReceived

{:id="Microbit_Device_Information.ManufacturerNameStringReceived"} ManufacturerNameStringReceived(*Manufacturer_Name_String*{:.text})
: Event for ManufacturerNameStringReceived

{:id="Microbit_Device_Information.ModelNumberStringReceived"} ModelNumberStringReceived(*Model_Number_String*{:.text})
: Event for ModelNumberStringReceived

{:id="Microbit_Device_Information.SerialNumberStringReceived"} SerialNumberStringReceived(*Serial_Number_String*{:.text})
: Event for SerialNumberStringReceived

### Methods  {#Microbit_Device_Information-Methods}

{:.methods}

{:id="Microbit_Device_Information.ReadFirmwareRevisionString" class="method"} <i/> ReadFirmwareRevisionString()
: Method for ReadFirmwareRevisionString

{:id="Microbit_Device_Information.ReadHardwareRevisionString" class="method"} <i/> ReadHardwareRevisionString()
: Method for ReadHardwareRevisionString

{:id="Microbit_Device_Information.ReadManufacturerNameString" class="method"} <i/> ReadManufacturerNameString()
: Method for ReadManufacturerNameString

{:id="Microbit_Device_Information.ReadModelNumberString" class="method"} <i/> ReadModelNumberString()
: Method for ReadModelNumberString

{:id="Microbit_Device_Information.ReadSerialNumberString" class="method"} <i/> ReadSerialNumberString()
: Method for ReadSerialNumberString

## Microbit_Dfu_Control  {#Microbit_Dfu_Control}

Component for Microbit_Dfu_Control



### Properties  {#Microbit_Dfu_Control-Properties}

{:.properties}

{:id="Microbit_Dfu_Control.BluetoothDevice" .component} *BluetoothDevice*
: Property for BluetoothDevice

### Events  {#Microbit_Dfu_Control-Events}

{:.events}

{:id="Microbit_Dfu_Control.DFUControlReceived"} DFUControlReceived(*dfu_control*{:.number})
: Event for DFUControlReceived

{:id="Microbit_Dfu_Control.WroteDFUControl"} WroteDFUControl(*dfu_control*{:.number})
: Event for WroteDFUControl

### Methods  {#Microbit_Dfu_Control-Methods}

{:.methods}

{:id="Microbit_Dfu_Control.ReadDFUControl" class="method"} <i/> ReadDFUControl()
: Method for ReadDFUControl

{:id="Microbit_Dfu_Control.WriteDFUControl" class="method"} <i/> WriteDFUControl(*DFU_Control*{:.number})
: Method for WriteDFUControl

## Microbit_Event  {#Microbit_Event}

Component for Microbit_Event



### Properties  {#Microbit_Event-Properties}

{:.properties}

{:id="Microbit_Event.BluetoothDevice" .component} *BluetoothDevice*
: Property for BluetoothDevice

### Events  {#Microbit_Event-Events}

{:.events}

{:id="Microbit_Event.MicroBitEventReceived"} MicroBitEventReceived(*Event_Type_And_Value*{:.number})
: Event for MicroBitEventReceived

{:id="Microbit_Event.MicroBitRequirementsReceived"} MicroBitRequirementsReceived(*microbit_reqs_value*{:.number})
: Event for MicroBitRequirementsReceived

{:id="Microbit_Event.WroteClientEvent"} WroteClientEvent(*Event_Types_And_Values*{:.list})
: Event for WroteClientEvent

{:id="Microbit_Event.WroteClientRequirements"} WroteClientRequirements(*Client_Requirements_Value*{:.list})
: Event for WroteClientRequirements

### Methods  {#Microbit_Event-Methods}

{:.methods}

{:id="Microbit_Event.ReadMicroBitEvent" class="method"} <i/> ReadMicroBitEvent()
: Method for ReadMicroBitEvent

{:id="Microbit_Event.ReadMicroBitRequirements" class="method"} <i/> ReadMicroBitRequirements()
: Method for ReadMicroBitRequirements

{:id="Microbit_Event.RequestMicroBitEventUpdates" class="method"} <i/> RequestMicroBitEventUpdates()
: Method for RequestMicroBitEventUpdates

{:id="Microbit_Event.RequestMicroBitRequirementsUpdates" class="method"} <i/> RequestMicroBitRequirementsUpdates()
: Method for RequestMicroBitRequirementsUpdates

{:id="Microbit_Event.StopMicroBitEventUpdates" class="method"} <i/> StopMicroBitEventUpdates()
: Method for StopMicroBitEventUpdates

{:id="Microbit_Event.StopMicroBitRequirementsUpdates" class="method"} <i/> StopMicroBitRequirementsUpdates()
: Method for StopMicroBitRequirementsUpdates

{:id="Microbit_Event.WriteClientEvent" class="method"} <i/> WriteClientEvent(*Event_Types_And_Values*{:.list})
: Method for WriteClientEvent

{:id="Microbit_Event.WriteClientRequirements" class="method"} <i/> WriteClientRequirements(*Client_Requirements_Value*{:.list})
: Method for WriteClientRequirements

## Microbit_Generic_Access  {#Microbit_Generic_Access}

Component for Microbit_Generic_Access



### Properties  {#Microbit_Generic_Access-Properties}

{:.properties}

{:id="Microbit_Generic_Access.BluetoothDevice" .component} *BluetoothDevice*
: Property for BluetoothDevice

### Events  {#Microbit_Generic_Access-Events}

{:.events}

{:id="Microbit_Generic_Access.AppearanceReceived"} AppearanceReceived(*Category*{:.number})
: Event for AppearanceReceived

{:id="Microbit_Generic_Access.DeviceNameReceived"} DeviceNameReceived(*Name*{:.text})
: Event for DeviceNameReceived

{:id="Microbit_Generic_Access.PeripheralPreferredConnectionParametersReceived"} PeripheralPreferredConnectionParametersReceived(*Minimum_Connection_interval*{:.number},*Maximum_Connection_Interval*{:.number},*Slave_Latency*{:.number},*Connection_Supervision_Timeout_Multiplier*{:.number})
: Event for PeripheralPreferredConnectionParametersReceived

{:id="Microbit_Generic_Access.WroteDeviceName"} WroteDeviceName(*Name*{:.text})
: Event for WroteDeviceName

### Methods  {#Microbit_Generic_Access-Methods}

{:.methods}

{:id="Microbit_Generic_Access.ReadAppearance" class="method"} <i/> ReadAppearance()
: Method for ReadAppearance

{:id="Microbit_Generic_Access.ReadDeviceName" class="method"} <i/> ReadDeviceName()
: Method for ReadDeviceName

{:id="Microbit_Generic_Access.ReadPeripheralPreferredConnectionParameters" class="method"} <i/> ReadPeripheralPreferredConnectionParameters()
: Method for ReadPeripheralPreferredConnectionParameters

{:id="Microbit_Generic_Access.WriteDeviceName" class="method"} <i/> WriteDeviceName(*Name*{:.text})
: Method for WriteDeviceName

## Microbit_Generic_Attribute  {#Microbit_Generic_Attribute}

Component for Microbit_Generic_Attribute



### Properties  {#Microbit_Generic_Attribute-Properties}

{:.properties}

{:id="Microbit_Generic_Attribute.BluetoothDevice" .component} *BluetoothDevice*
: Property for BluetoothDevice

### Events  {#Microbit_Generic_Attribute-Events}

{:.events}
None


### Methods  {#Microbit_Generic_Attribute-Methods}

{:.methods}
None


## Microbit_Io_Pin  {#Microbit_Io_Pin}

Component for Microbit_Io_Pin



### Properties  {#Microbit_Io_Pin-Properties}

{:.properties}

{:id="Microbit_Io_Pin.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Io_Pin-Events}

{:.events}

{:id="Microbit_Io_Pin.PinADConfigurationReceived"} PinADConfigurationReceived(*Pin_AD_Config_Value*{:.list})
: The <code>PinADConfigurationReceived</code> event is run after a successful call to the
 <a href="#ReadPinADConfiguration"><code>ReadPinADConfiguration</code></a> method is returned
 by the micro:bit.

 __Parameters__:

     * <code>Pin\_AD\_Config\_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of analog/digital pin states configured on the micro:bit.

{:id="Microbit_Io_Pin.PinDataReceived"} PinDataReceived(*IO_Pin_Data*{:.number})
: The <code>PinDataReceived</code> event will be run after the micro:bit sends the status of its
 input pins. This will typically follow calls to
 <a href="#ReadPinData"><code>ReadPinData</code></a> or
 <a href="#RequestPinData"><code>RequestPinData</code></a>.

 __Parameters__:

     * <code>IO_Pin_Data</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       The state of the micro:bit's input pins. Pins not configured for input will have 0 value.

{:id="Microbit_Io_Pin.PinIOConfigurationReceived"} PinIOConfigurationReceived(*Pin_IO_Config_Value*{:.list})
: The <code>PinIOConfigurationReceived</code> event will be run after the micro:bit's pins'
 input/output configuration is read. <code>Pin\_IO\_Config\_Value</code> will be a list of three
 bytes valued from 0-255 composing a 19-bit mask indicating the input or output state of each
 of the 19 pins provided by the micro:bit. A 0 bit indicates output and a 1 bit indicates input.

 __Parameters__:

     * <code>Pin\_IO\_Config\_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of 8-bit values that are composed into a 19-bit mask, one bit per pin on the micro:bit.

{:id="Microbit_Io_Pin.WrotePWMControl"} WrotePWMControl(*PWM_Control_Field*{:.list})
: The <code>WrotePWMControl</code> event is run after a successful write to the micro:bit's
 pulse-width modulation control service. The value of the control field that was written will
 be passed as the <code>PWM\_Control\_Field</code>.

 __Parameters__:

     * <code>PWM\_Control\_Field</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       The control information written to the micro:bit.

{:id="Microbit_Io_Pin.WrotePinADConfiguration"} WrotePinADConfiguration(*Pin_AD_Config_Value*{:.list})
: The <code>WrotePinADConfiguration</code> event is run after a successful write to the
 micro:bit's configuration server for analog and digital pins. <code>Pin\_AD\_Config\_Value</code>
 will be the list of bytes that were written as part of the last call to the service.

 __Parameters__:

     * <code>Pin\_AD\_Config\_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of 8-bit values that are composed into a 19-bit mask, one bit per pin on the micro:bit.

{:id="Microbit_Io_Pin.WrotePinData"} WrotePinData(*IO_Pin_Data*{:.list})
: The <code>WrotePinData</code> event will be run after the micro:bit's output pins are
 successfully written by a call to the <a href="#WritePinData"><code>WritePinData</code></a>
 method.

 __Parameters__:

     * <code>IO\_Pin\_Data</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash; A list of up to 19 values from 0-255 that were written to the micro:bit's
       pins from the last call to <a href="#WritePinData"><code>WritePinData</code></a>.

{:id="Microbit_Io_Pin.WrotePinIOConfiguration"} WrotePinIOConfiguration(*Pin_IO_Config_Value*{:.list})
: The <code>WrotePinIOConfiguration</code> event will run after a successful update of the
 micro:bit's input/output pin configuration. <code>Pin\_IO\_Config\_Value</code> that was sent to
 the device will be passed as a parameter to the event.

 __Parameters__:

     * <code>Pin\_IO\_Config\_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of 8-bit values that are composed into a 19-bit mask, one bit per pin on the micro:bit.

### Methods  {#Microbit_Io_Pin-Methods}

{:.methods}

{:id="Microbit_Io_Pin.ReadPinADConfiguration" class="method"} <i/> ReadPinADConfiguration()
: Read the state of the micro:bit's pin configuration, specifically whether each pin is
 configured as digital (0 or 1) or analog (0 to 255). After a successful read, the
 <a href="#PinADConfigurationReceived"><code>PinADConfigurationReceived</code></a> event will
 be run.

{:id="Microbit_Io_Pin.ReadPinData" class="method"} <i/> ReadPinData()
: Read a single sample of the pin states from the micro:bit. On successful read, the
 <a href="#PinDataReceived"><code>PinDataReceived</code></a> event will be run. Prior to reading
 the pins, one should configure the pins for input using the <a
 href="#WritePinIOConfiguration"><code>WritePinIOConfiguration</code></a> method.

{:id="Microbit_Io_Pin.ReadPinIOConfiguration" class="method"} <i/> ReadPinIOConfiguration()
: Read the current input/output configuration of the micro:bit's pins. After a successful read,
 the <a href="#PinIOConfigurationReceived"><code>PinIOConfigurationReceived</code></a> event
 will be run.

{:id="Microbit_Io_Pin.RequestPinDataUpdates" class="method"} <i/> RequestPinDataUpdates()
: Request updates to any micro:bit pins configured as input pins. After requesting updates, the
 <a href="#PinDataReceived"><code>PinDataReceived</code></a> will be run whenever the micro:bit
 reports changes to its input pins.

{:id="Microbit_Io_Pin.StopPinDataUpdates" class="method"} <i/> StopPinDataUpdates()
: Stop receiving updates about the state of the micro:bit's I/O pins. Note that there may be
 pending updates that have not been processed that will result in additional
 <a href="#PinDataReceived"><code>PinDataReceived</code></a> events.

{:id="Microbit_Io_Pin.WritePWMControl" class="method"} <i/> WritePWMControl(*PWM_Control_Field*{:.list})
: Writes the PWM control field on the micro:bit. The PWM control field is a variable length
 array of one or two instances of a data structure containing a 1-byte pin field (range 0-19),
 a 2-byte value field (range 0-1024), and a 4-byte period field (in milliseconds).

 __Parameters__:

     * <code>PWM\_Control\_Field</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       The PWM control field data as defined in the WritePWMControl method description.

{:id="Microbit_Io_Pin.WritePinADConfiguration" class="method"} <i/> WritePinADConfiguration(*Pin_AD_Config_Value*{:.list})
: The <code>WritePinADConfiguration</code> is used to configure whether pins on the micro:bit
 are analog or digital. The <code>Pin\_AD\_Config\_Value</code> is composed of three bytes that
 represent 19 bits, one for each pin on the micro:bit. A 0 bit indicates a digital pin and a
 1 bit indicates an analog pin. The
 <a href="#WrotePinADConfiguration"><code>WrotePinADConfiguration</code></a> event will be run
 after successfully writing a new pin configuration.

 __Parameters__:

     * <code>Pin\_AD\_Config\_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of 8-bit values that are composed into a 19-bit mask, one bit per pin on the micro:bit.

{:id="Microbit_Io_Pin.WritePinData" class="method"} <i/> WritePinData(*IO_Pin_Data*{:.list})
: The <code>WritePinData</code> is used to set the output values of the micro:bit's pins if
 configured as output pins using the
 <a href="#WritePinIOConfiguration"><code>WritePinIOConfiguration</code></a> method. After the
 pins are written, the <a href="#WrotePinData"><code>WrotePinData</code></a> event will be run.

 __Parameters__:

     * <code>IO\_Pin\_Data</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash; A list of up to 19 values from 0-255 to be output to the micro:bit's pins.

{:id="Microbit_Io_Pin.WritePinIOConfiguration" class="method"} <i/> WritePinIOConfiguration(*Pin_IO_Config_Value*{:.list})
: The <code>WritePinIOConfiguration</code> method is used to configure the micro:bit's pins for
 input or output. The <code>Pin\_IO\_Config\_Value</code> parameter should be a 3-element list
 where each element is a number from 0-255 composing a 19-bit bitmask. A 0-bit indicates an
 output and a 1-bit indicates an input.

 __Parameters__:

     * <code>Pin_IO_Config_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of 8-bit values that are composed into a 19-bit mask, one bit per pin on the micro:bit.

## Microbit_Led  {#Microbit_Led}

Component for Microbit_Led



### Properties  {#Microbit_Led-Properties}

{:.properties}

{:id="Microbit_Led.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Led-Events}

{:.events}

{:id="Microbit_Led.LEDMatrixStateReceived"} LEDMatrixStateReceived(*LED_Matrix_State*{:.list})
: The <code>LEDMatrixStateReceived</code> event is run when the state of the micro:bit's LED
 matrix is read from the device. The <code>LED_Matrix_State</code> is a list of 5 values, one
 for each row of the matrix. Each value is an number from 0-31. From left to right, the LEDs
 are valued 16, 8, 4, 2, 1.<br>\n\n

 __Parameters__:

    + <code>LED_Matrix_State</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash; A list of 5 values, one for each row, with
      each value being between 0-31 to indicate which LEDs in that row are on.

{:id="Microbit_Led.ScrollingDelayReceived"} ScrollingDelayReceived(*Scrolling_Delay_Value*{:.number})
: The <code>Scrolling_Delay_Value</code> event will be run after requesting the scrolling delay
 for the micro:bit's LED matrix through the
 <a href="#ReadScrollingDelay><code>ReadScrollingDelay</code></a> method.

 __Parameters__:

     * <code>Scrolling_Delay_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The delay between characters on the LED matrix, in milliseconds.

{:id="Microbit_Led.WroteLEDMatrixState"} WroteLEDMatrixState(*LED_Matrix_State*{:.list})
: The <code>WriteLEDMatrixState</code> event will be run after the micro:bit's LED matrix is
 written due to a call to <a href="#WriteLEDMatrixState"><code>WriteLEDMatrixState</code></a>.
 The LED_Matrix_State will be the same as in the call to <code>WriteLEDMatrixState</code> to
 differentiate the response to potentially many calls to write the LED matrix.

 __Parameters__:

     * <code>LED_Matrix_State</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash; The values written to the LED matrix as specified in the previous call
       to [`WriteLEDMatrixState`](#Microbit_Led.WriteLEDMatrixState) that resulted in this event.

{:id="Microbit_Led.WroteLEDText"} WroteLEDText(*LED_Text_Value*{:.list})
: The <code>WroteLEDText</code> event will be run after text is written to the micro:bit's LED
 matrix through a call to <a href="#WriteLEDText"><code>WriteLEDText</code></a>. The value of
 the written text will be given by the <code>LED_Text_Value</code> parameter.

 __Parameters__:

     * <code>LED_Text_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash; The text to write to the LED matrix.

{:id="Microbit_Led.WroteScrollingDelay"} WroteScrollingDelay(*Scrolling_Delay_Value*{:.number})
: The <code>WroteScrollingDelay</code> event will be run after the micro:bit's scrolling delay
 is successfully read after a call to the
 <a href="#WriteScrollingDelay"><code>WriteScrollingDelay</code></a> method.

 __Parameters__:

     * <code>Scrolling_Delay_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The delay between characters on the LED matrix, in milliseconds.

### Methods  {#Microbit_Led-Methods}

{:.methods}

{:id="Microbit_Led.ReadLEDMatrixState" class="method"} <i/> ReadLEDMatrixState()
: Read the current state of the LED matrix from the micro:bit. The LED matrix state will be
 reported through the <a href="#LEDMatrixStateReceived"><code>LEDMatrixStateReceived</code></a>
 event.

{:id="Microbit_Led.ReadScrollingDelay" class="method"} <i/> ReadScrollingDelay()
: Read the current scroll delay for the micro:bit's LED matrix. After a successful read, the
 <a href="#ScrollingDelayReceived"><code>ScrollingDelayReceived</code></a> event will be run.

{:id="Microbit_Led.WriteLEDMatrixState" class="method"} <i/> WriteLEDMatrixState(*LED_Matrix_State*{:.list})
: Write the state of the micro:bit's LED matrix. <code>LED_Matrix_State</code> should be a list
 of 5 numbers from 0-31 to indicate which LEDs should be turned on in each of the 5 rows of the
 LED matrix. From left to right, the values of the LEDs are 16, 8, 4, 2, 1. For example, if you
 want to turn on the LEDs in one row such that power states were 10011, you would send the value
 (16 + 2 + 1) or 19 for the row. After the write operation completes, the
 <a href="#WroteLEDMatrixState"><code>WroteLEDMatrixState</code></a> event will be run.

 __Parameters__:

     * <code>LED_Matrix_State</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash; A list of 5 numbers, one for each row of the LED matrix, where each
       value is the integer value of the bit array for the nth row of the LED matrix.

{:id="Microbit_Led.WriteLEDText" class="method"} <i/> WriteLEDText(*LED_Text_Value*{:.text})
: Write text to the micro:bit's LED matrix. The rate at which each character appears on the
 micro:bit's display depends on the last scroll value written by
 <a href="#WriteScrollDelay"><code>WriteScrollDelay</code></a>. Due to the allowable length of
 Bluetooth low energy packets, the strings sent are restricted to 20 or more UTF-8 octets.
 Attempts to write strings longer than 20 octets will result in truncated messages.

 __Parameters__:

    + <code>LED_Text_Value</code> (_string_) &mdash; The text to write. Strings are limited to
      a length of 20 UTF-8 octets.

{:id="Microbit_Led.WriteScrollingDelay" class="method"} <i/> WriteScrollingDelay(*Scrolling_Delay_Value*{:.number})
: Set the delay between characters displayed on the micro:bit's LED matrix, in milliseconds.
 After writing the value, the
 <a href="#WroteScrollingDelay"><code>WriteScrollingDelay</code></a> will be called.

 __Parameters__:

     * <code>Scrolling_Delay_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The delay between characters on the LED matrix, in milliseconds.

## Microbit_Magnetometer  {#Microbit_Magnetometer}

Component for Microbit_Magnetometer



### Properties  {#Microbit_Magnetometer-Properties}

{:.properties}

{:id="Microbit_Magnetometer.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Magnetometer-Events}

{:.events}

{:id="Microbit_Magnetometer.MagnetometerBearingReceived"} MagnetometerBearingReceived(*bearing_value*{:.number})
: The <code>MagnetometerBearingReceived</code> event is run whenever bearing samples are
 received from the micro:bit. This is usually a result of performing a
 <a href="#ReadMagnetometerBearing">read</a> or
 <a href="#RequestMagnetometerBearingUpdates">request</a> operation. The bearing value is
 reported as degrees relative to North.

 __Parameters__:

     * <code>bearing_value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The bearing from North, in degrees.

{:id="Microbit_Magnetometer.MagnetometerDataReceived"} MagnetometerDataReceived(*Magnetometer_X*{:.number},*Magnetometer_Y*{:.number},*Magnetometer_Z*{:.number})
: The <code>MagnetometerDataReceived</code> event is run whenever magnetometer samples are
 received from the micro:bit. This is usually a result of performing a
 <a href="#ReadMagnetometerData">read</a> or
 <a href="#RequestMagnetometerDataUpdates">request</a> operation. The X, Y, and Z values are in
 milli-teslas, and so should be scaled by 1/1000.

 __Parameters__:

    + <code>Magnetometer_X</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The X value of the magnetometer, in milliT.
    + <code>Magnetometer_Y</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Y value of the magnetometer, in milliT.
    + <code>Magnetometer_Z</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Z value of the magnetometer, in milliT.

{:id="Microbit_Magnetometer.MagnetometerPeriodReceived"} MagnetometerPeriodReceived(*Magnetometer_Period*{:.number})
: The <code>MagnetometerPeriodReceived</code> event is run after the micro:bit's magnetometer
 period is read from the device.

 __Parameters__:

     * <code>Magnetometer_Period</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The current reporting interval for the micro:bit's magnetometer, in milliseconds.

{:id="Microbit_Magnetometer.WroteMagnetometerPeriod"} WroteMagnetometerPeriod(*Magnetometer_Period*{:.number})
: The <code>WroteMagnetometerPeriod</code> event is run after the micro:bit reports its period
 as requested by an earlier call to the
 <a href="#ReadMagnetometerPeriod"><code>ReadAccelerometerPeriod</code></a> method.

 __Parameters__:

     * <code>Magnetometer_Period</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The reporting periodf or the micro:bit's magnetometer, in milliseconds.

### Methods  {#Microbit_Magnetometer-Methods}

{:.methods}

{:id="Microbit_Magnetometer.ReadMagnetometerBearing" class="method"} <i/> ReadMagnetometerBearing()
: Read a single bearing sample from the micro:bit. On successful read, the
 <a href="#MagnetometerBearingReceived"><code>MagnetometerBearingReceived</code></a> event
 will be run.

{:id="Microbit_Magnetometer.ReadMagnetometerData" class="method"} <i/> ReadMagnetometerData()
: Read a single sample of magnetometer data from the micro:bit. On successful read, the
 <a href="#MagnetometerDataReceived"><code>MagnetometerDataReceived</code></a> event will be
 run.

{:id="Microbit_Magnetometer.ReadMagnetometerPeriod" class="method"} <i/> ReadMagnetometerPeriod()
: Read the current report rate for the micro:bit magnetometer. After the period is read, it will
 be received by the
 <a href="#MagnetometerPeriodReceived"><code>MagnetometerPeriodReceived</code></a> event.

{:id="Microbit_Magnetometer.RequestMagnetometerBearingUpdates" class="method"} <i/> RequestMagnetometerBearingUpdates()
: Request notifications of changes in the micro:bit's bearing. Changes in the bearing will be
 reported at a rate determined by the last period value set by a call to
 <a href="#WriteMagnetometerPeriod"><code>WriteMagnetometerPeriod</code></a>. Bearing data
 will be reported through the
 <a href="#MagnetometerBearingReceived"><code>MagnetometerBearingReceived</code></a> event.

{:id="Microbit_Magnetometer.RequestMagnetometerDataUpdates" class="method"} <i/> RequestMagnetometerDataUpdates()
: Request notifications of changes in the micro:bit's magnetometer. Changes in the magnetometer
 will be reported at a rate determined by the last period value set by a call to
 <a href="#WriteMagnetometerPeriod"><code>WriteMagnetometerPeriod</code></a>. Magnetometer
 data will be reported through the
 <a href="#MagnetometerDataReceived"><code>MagnetometerDataReceived</code></a> event.

{:id="Microbit_Magnetometer.StopMagnetometerBearingUpdates" class="method"} <i/> StopMagnetometerBearingUpdates()
: Stop receiving updates from the micro:bit's magnetometer. Note that there may be pending
 messages from the device that will still be reported through the
 <a href="#MagnetometerBearingReceived"><code>MagnetometerBearingReceived</code></a> event.

{:id="Microbit_Magnetometer.StopMagnetometerDataUpdates" class="method"} <i/> StopMagnetometerDataUpdates()
: Stop receiving updates from the micro:bit's magnetometer. Note that there may be pending
 messages from the device that will still be reported through the
 <a href="#MagnetometerDataReceived"><code>MagnetometerDataReceived</code></a> event.

{:id="Microbit_Magnetometer.WriteMagnetometerPeriod" class="method"} <i/> WriteMagnetometerPeriod(*Magnetometer_Period*{:.number})
: Use the <code>WriteMagnetometerPeriod</code> method to change how frequently the micro:bit
 sends magnetometer data to App Inventor. The period is measured in milliseconds. According to
 the micro:bit specification, valid values are 1, 2, 5, 10, 20, 80, 160 and 640 milliseconds.

 __Parameters__:

     * <code>Magnetometer_Period</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The new magnetometer reporting period, in milliseconds.

## Microbit_Temperature  {#Microbit_Temperature}

Component for Microbit_Temperature



### Properties  {#Microbit_Temperature-Properties}

{:.properties}

{:id="Microbit_Temperature.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Temperature-Events}

{:.events}

{:id="Microbit_Temperature.TemperaturePeriodReceived"} TemperaturePeriodReceived(*temperature_period_value*{:.number})
: The <code>TemperaturePeriodReceived</code> event is run after the micro:bit's temperature
 reporting period is read from the device.

 __Parameters__:

     * <code>temperature_period_value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The current reporting interval for the micro:bit's temperature sensor.

{:id="Microbit_Temperature.TemperatureReceived"} TemperatureReceived(*temperature_value*{:.number})
: The <code>TemperatureReceived</code> event is run whenever temperature samples are received
 from the micro:bit. This is usually a result of performing a
 <a href="#ReadTemperature">read</a> or <a href="#RequestTemperatureUpdates">request updates</a>
 operation. The temperature value is measured in degrees Celsius.

 __Parameters__:

     * <code>temperature_value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The temperature measured by the micro:bit, in degrees Celsius

{:id="Microbit_Temperature.WroteTemperaturePeriod"} WroteTemperaturePeriod(*temperature_period_value*{:.number})
: The <code>WroteTemperaturePeriod</code> event is run after the micro:bit's temperature
 reporting period is written to the device.

 __Parameters__:

     * <code>temperature_period_value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The new reporting interval for the micro:bit's temperature sensor.

### Methods  {#Microbit_Temperature-Methods}

{:.methods}

{:id="Microbit_Temperature.ReadTemperature" class="method"} <i/> ReadTemperature()
: Read a single sample of temperature data from the micro:bit. On successful read, the
 <a href="#TemperatureDataReceived"><code>TemperatureDataReceived</code></a> event will be run.

{:id="Microbit_Temperature.ReadTemperaturePeriod" class="method"} <i/> ReadTemperaturePeriod()
: Read the current report rate for the micro:bit's temperature sensor. After the period is read,
 it will be received by the
 <a href="#TemperaturePeriodReceived"><code>TemperaturePeriodReceived</code></a> event.

{:id="Microbit_Temperature.RequestTemperatureUpdates" class="method"} <i/> RequestTemperatureUpdates()
: Request notifications of changes in the micro:bit's temperature sensor. Changes in the
 temperature will be reported at a rate determined by the last period value set by a call to
 <a href="#WriteTemperaturePeriod"><code>WriteTemperaturePeriod</code></a>. Temperature data
 will be reported through the
 <a href="#TemperatureDataReceived"><code>TemperatureDataReceived</code></a> event.

{:id="Microbit_Temperature.StopTemperatureUpdates" class="method"} <i/> StopTemperatureUpdates()
: Stop receiving updates from the micro:bit's temperature sensor. Note that there may be
 pending messages from the device that will still be reported through the
 <a href="#TemperatureDataReceived"><code>TemperatureDataReceived</code></a> event.

{:id="Microbit_Temperature.WriteTemperaturePeriod" class="method"} <i/> WriteTemperaturePeriod(*temperature_period_value*{:.number})
: Use the <code>WriteTemperaturePeriod</code> method to change how frequently the micro:bit sends
 temperature data to App Inventor. The period is measured in milliseconds.

 __Parameters__:

     * <code>temperature_period_value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The new reporting period for the micro:bit's temperature sensor.

## Microbit_Uart  {#Microbit_Uart}

Component for Microbit_Uart



### Properties  {#Microbit_Uart-Properties}

{:.properties}

{:id="Microbit_Uart.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Uart-Events}

{:.events}

{:id="Microbit_Uart.TXCharacteristicReceived"} TXCharacteristicReceived(*UART_TX_Field*{:.list})
: The <code>TXCharacteristicReceived</code> event is run whenever messages are received over the
 micro:bit's serial UART protocol.

 __Parameters__:

     * <code>UART_TX_FIELD</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/listsU.html#makealist">_list_</a>) &mdash;
       A list of unsigned byte values read from the device.

{:id="Microbit_Uart.WroteRXCharacteristic"} WroteRXCharacteristic(*UART_TX_Field*{:.list})
: The <code>WroteRXCharacteristic</code> event is run after a message is written to the micro:bit
 via its serial UART.

 __Parameters__:

     * <code>UART_TX_FIELD</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/listsU.html#makealist">_list_</a>) &mdash;
       A list of unsigned byte values written to the device.

### Methods  {#Microbit_Uart-Methods}

{:.methods}

{:id="Microbit_Uart.RequestTXCharacteristic" class="method"} <i/> RequestTXCharacteristic()
: Requests notifications of messages received from the micro:bit's serial UART. New messages will
 be received through the
 <a href='#TXCharacteristicReceived'><code>TXCharacteristicReceived</code></a>
 event.

{:id="Microbit_Uart.StopTXCharacteristicUpdates" class="method"} <i/> StopTXCharacteristicUpdates()
: Stops receiving updates from the micro:bit's serial UART. Note that there may be pending
 messages from the device that will still be reported through the
 <a href='#TXCharacteristicReceived'><code>TXCharacteristicReceived</code></a> event.

{:id="Microbit_Uart.WriteRXCharacteristic" class="method"} <i/> WriteRXCharacteristic(*UART_TX*{:.any})
: Writes the given value <code>UART_TX</code> to the micro:bit. The size of the message will
 depend on the value of <code>UART_TX</code>. Numbers will be converted to integers and sent
 as 32-bit integer values. Strings will be encoded using UTF-8. Lists of objects will be
 sent as a sequence of bytes using the aforementioned rules for numbers and strings.

 __Parameters__:

     * <code>UART_TX</code> (_any_) &mdash;
       The value to transmit to the RX "pin" of the micro:bit. Strings will be encoded as UTF-8,
       numbers will be sent as 32-bit integers. Lists of values will be converted into be
       converted into a sequence of bytes depending on the type of each value in the list.

## TextRecognizerGood  {#TextRecognizerGood}

Component for TextRecognizerGood



### Properties  {#TextRecognizerGood-Properties}

{:.properties}

{:id="TextRecognizerGood.List" .text .ro .bo} *List*
: Input an image and outputs the text on the image

### Events  {#TextRecognizerGood-Events}

{:.events}

{:id="TextRecognizerGood.ErrorOccured"} ErrorOccured(*error*{:.text})
: Event for ErrorOccured

{:id="TextRecognizerGood.Result"} Result(*result*{:.text})
: Event for Result

### Methods  {#TextRecognizerGood-Methods}

{:.methods}

{:id="TextRecognizerGood.newFunction" class="method"} <i/> newFunction(*path*{:.text})
: Method for newFunction

{:id="TextRecognizerGood.setRecognizer" class="method"} <i/> setRecognizer(*path*{:.text})
: Method for setRecognizer
