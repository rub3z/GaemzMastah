using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace TestingGUI
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void StartInternetExplorer_Click(object sender, RoutedEventArgs e)
        {
            Process ie = new Process();
            ie.StartInfo.FileName = "iexplore.exe";
            ie.Start();
        }
        private void StartNotepad_Click(object sender, RoutedEventArgs e)
        {
            Process notePad = new Process();
            notePad.StartInfo.FileName = "notepad.exe";
            notePad.Start();
        }
        private void PrintHelloWorld_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("HelloWorld");
        }
    }
}
